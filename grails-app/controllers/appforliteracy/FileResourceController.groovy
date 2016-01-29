package appforliteracy

import grails.io.IOUtils
import org.grails.web.json.JSONObject

class FileResourceController {

    def index = { redirect(action:list,params:params) }
    static transactional = true

    def allowedMethods = []

    def list = {
        def fileResourceInstanceList = []
//        def f = new File( grailsApplication.config.images.location.toString() )
//        if( f.exists() ){
//            f.eachFile(){ file->
//                if( !file.isDirectory() )
//                    fileResourceInstanceList.add( file.name )
//            }
//        }
        [ fileResourceInstanceList: fileResourceInstanceList ]
        render(view: 'list.gsp')

    }

    def delete = {
        def filename = params.id.replace('###', '.')
        def file = new File( grailsApplication.config.images.location.toString() + File.separatorChar +   filename )
        file.delete()
        flash.message = "file ${filename} removed"
        redirect( action:list )
    }

    def upload = {
        def f = request.getFile('fileUpload')

        String myString = IOUtils.toString(f.getInputStream(), "UTF-8")

        JSONObject input = new JSONObject(myString)

        List<String> keys

        try {
            ParseInputService parser = new ParseInputService("./module-input-configuration/input_config.txt")
            keys = parser.parseInputFile(input)
        } catch (Exception e) {
            println e.message
        }

        //Write to DB, pass keys, JSON
        WriteInputToDBService writer = new WriteInputToDBService(input, keys)
        writer.writeToDB()

        render(view: 'list.gsp')
    }
}
