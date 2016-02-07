package appforliteracy

import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject
import appforliteracy.moduleInputDomains.FirstExample

class FirstExampleController {

    def start() {

        String inputID = Module.findByModuleId(params.id).inputID
        FirstExample input = FirstExample.findByModuleDataID(inputID)

        String[] words = input.words
        [lsOut:words, modID: params.id]
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
        WriteModuleOutputToDBService writer = new WriteModuleOutputToDBService(params.modID)
        String id = writer.writeToDB(output)
        redirect(controller: "FileOutput", action: "output", params: [id: id])
    }

}
