package appforliteracy

import appforliteracy.moduleInputDomains.ModuleOutput
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject


class WriteModuleOutputToDBService {
    String moduleID

    WriteModuleOutputToDBService(String moduleID) {
        this.moduleID = moduleID
    }

    String writeToDB (JSONObject output) {
        JSONObject newOutput = parseJSON(output)
        List<String> keys = new ArrayList<>()
        keys.add("headers")
        keys.add("valueRows")
        keys.add("type")
        WriteModuleDataToDBService writer = new WriteModuleDataToDBService(newOutput, keys)
        String id = writer.writeToDB()
        Module m = Module.findByModuleId(moduleID)
        List<String> outputs = m.outputIDs
        if(outputs == null) {
            m.outputIDs = [id]
        } else {
            m.outputIDs.add(id)
        }
        m.save(flush: true)
        m = Module.findByModuleId(moduleID)
        println("size: " + m.outputIDs.size())
        return id
        //TODO: Save output ID in Module
    }

    private JSONObject parseJSON (JSONObject output) {
        JSONObject newOutput = new JSONObject()
        newOutput.headers = output.headers
        String[][] values = output.values
        String[] concatenatedValues = new String[values.length]
        for (int row = 0; row < values.length; row++) {
            String rowString = values[row][0]
            for (int column = 1; column < values[row].length; column++) {
                rowString += ","
                rowString += values[row][column]
            }
            concatenatedValues[row] = rowString

        }
        newOutput.put("valueRows", concatenatedValues)
        newOutput.put("type", "ModuleOutput") //Necessary?
        return newOutput
    }
}
