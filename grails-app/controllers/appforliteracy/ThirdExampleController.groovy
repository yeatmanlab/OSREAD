package appforliteracy

import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject
import appforliteracy.moduleInputDomains.ThirdExample

class ThirdExampleController {

    def start() {
        println(params.id)
        ThirdExample input = ThirdExample.findByModuleDataID(params.id)

        String letter = input.favoriteLetter
        [lsOut:[letter]]
    }

    def submit() {
        String[] words = params.words

        JSONObject output = new JSONObject()
        JSONArray resultRows = new JSONArray()
        for (int i = 0; i < words.length; i++) {
            JSONArray row = new JSONArray()
            row.add(words[i])
            row.add(words[i].length())
            resultRows.add(row)
        }
        output.headers = ["word", "length"]
        output.values = resultRows
        WriteModuleOutputToDBService writer = new WriteModuleOutputToDBService(output)
        writer.writeToDB()
        render ("Done")
    }

}
