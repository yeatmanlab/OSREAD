package appforliteracy

import grails.io.IOUtils
import org.grails.web.json.JSONObject

class FileResourceController {

    final String CONFIG_PATH = "./module-input-configuration/input_config.txt"

    def index = { redirect(action: 'list') }

    def list = {
        Researcher r = new Researcher()
        println(r.list().size())
        ParseDataService parser = new ParseDataService(CONFIG_PATH)
        String[] types = parser.getModuleTypes()
        render(view: 'list.gsp', model: [type: types])
    }

    def upload = {
        def f = request.getFile('fileUpload')
        String myString = IOUtils.toString(f.getInputStream(), "UTF-8")
        JSONObject input = new JSONObject(myString)

        if(params.moduleTypes.equals(input.type)) {
            List<String> keys
            try {
                ParseDataService parser = new ParseDataService(CONFIG_PATH)
                keys = parser.parseDataFile(input)
            } catch (Exception e) {
                println e.message
            }

            WriteModuleDataToDBService writer = new WriteModuleDataToDBService(input, keys)
            String inputID = writer.writeToDB()
            Module m = new Module()
            m.inputID = inputID
            m.type = input.type
            m.save(flush: true)

            redirect(controller: input.type, action: "start", params: [id: inputID])
        } else {
            throw new IllegalStateException("Input file of wrong type")
            //TODO: Custom exception
        }
    }
}
