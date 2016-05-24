package appforliteracy

import grails.io.IOUtils
import grails.plugin.springsecurity.annotation.Secured
import org.grails.web.json.JSONObject
import metafunctionality.Module
import metafunctionality.ModuleInput

class FileInputController {

    /*
        This controller corresponds to the process of a researcher assigning a module to a learner. When the researcher
        assigns the module, they include a file containing individualized input for the student. This controller
        corresponds to that file input process.
     */

    @Secured('ROLE_RESEARCHER')
    def index () {
        print("index")
        redirect(action: 'list')
    }

    /*
        Lists the names of the modules which have been uploaded to the bintray.
    */
    @Secured('ROLE_RESEARCHER')
    def list () {
        print("list")
        List<String> types = ModuleListService.getModuleNames()

        [type: types, id: params.id]
    }

    /*
        Displays instruction messages to user to upload a file. When an appropriate file is uploaded, the content is
        inserted in the module and the module with content is assigned to the learner.
     */
    @Secured('ROLE_RESEARCHER')
    def upload () {
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
                // ^eg. bexample.Bexample 
                if(moduleInput != null){
                	println("new moduleInput created!")
                	} else {
                	println("no moduleInput made! (null)")
                	}
                for (key in keys) {
                	println("key" + key)
                	//these are the variables that you declared in the sample input file (eg rhymingCandidates)
                    moduleInput[key] = input[key]
                }

                Module m = new Module()
                m.inputID = moduleInput.moduleDataID
                println("[Type] inputID" + m.inputID)
                m.type = moduleInput.type
                println("[Type] type" + m.type)
                
                Learner learner = Learner.findById(params.learnerID)

                if (learner.moduleIDs != null) {
                	println("learner moduleID is NOT null")
                    learner.moduleIDs.add(m.moduleId)
                } else {
                	println("learner moduleID is null")
                    learner.moduleIDs = [m.moduleId]
                }

                println("[Type] name = " + moduleInput.name)

                // vv returns false for any module assignment besides the 1st one.
                // therefore, the moduleInput is created, but might be garbage collected after that.
                //GORM == Grails object relational mapping
                //"call save to persist your class/object to the database..."
                moduleInput.save(flush: true, failOnError: true)
                m.save(flush: true, failOnError: true)
                learner.save(flush: true, failOnError: true)

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
