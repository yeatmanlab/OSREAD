package appforliteracy

import grails.io.IOUtils
import org.grails.web.json.JSONObject
import metafunctionality.Module
import metafunctionality.ModuleInput








class FileInputController {

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
        String type = input.type
        if(params.moduleTypes.equals(type)) {
            List<String> keys
            try {
                ParseDataService parser = new ParseDataService(CONFIG_PATH)
                keys = parser.parseDataFile(input)
            } catch (Exception e) {
                println e.message
            }
            ModuleInput params = Class.forName(type.toLowerCase() + "." + type).newInstance()
            for (key in keys) {
                params[key] = input[key]
            }
            println(params.save(flush: true))


            Module m = new Module()
            m.inputID = params.moduleDataID
            m.type = input.type
            println(m.save(flush: true))
            String pack = input.type.toLowerCase()

            redirect(controller: pack + "." + input.type, action: "start", params: [id: m.moduleId]) //TODO: Only for testing, remove
        } else {
            throw new IllegalStateException("Input file of wrong type")
            //TODO: Custom exception
        }
    }
}
