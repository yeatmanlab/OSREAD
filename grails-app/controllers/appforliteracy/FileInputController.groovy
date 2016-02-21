package appforliteracy

import grails.io.IOUtils
import org.grails.web.json.JSONObject
import metafunctionality.Module
import metafunctionality.ModuleInput

class FileInputController {

    def index = { redirect(action: 'list') }

    def list = {
        List<String> types = ModuleListService.getModuleNames()

        [type: types, id: params.id]
    }

    def upload = {
        def f = request.getFile('fileUpload')
        if(f.isEmpty()) {
            render("Please select a file")
        } else if(params.moduleTypes == null) {
            render("Please select a module type")
        } else {
            String myString = IOUtils.toString(f.getInputStream(), "UTF-8")
            JSONObject input = new JSONObject(myString)
            String type = input.type
            if(params.moduleTypes.equals(type)) {

                List<String> keys
                try {
                    ParseDataService parser = new ParseDataService()
                    keys = parser.parseDataFile(input)
                } catch (Exception e) {
                    println e.message
                }
                ModuleInput moduleInput = Class.forName(type.toLowerCase() + "." + type).newInstance()
                for (key in keys) {
                    moduleInput[key] = input[key]
                }

                Module m = new Module()
                m.inputID = moduleInput.moduleDataID
                m.type = moduleInput.type

                Learner learner = Learner.findByUserID(params.learnerID)
                if (learner.moduleIDs != null) {
                    learner.moduleIDs.add(m.moduleId)
                } else {
                    learner.moduleIDs = [m.moduleId]
                }

                moduleInput.save(flush: true)
                m.save(flush: true)
                learner.save(flush: true)

                [id: params.learnerID]

            } else {
                //throw new IllegalStateException("Input file of wrong type")
                render("Input file of wrong type")
            }
        }
    }

    def logout() {
        redirect(controller:"Login", action:"index")
    }
}
