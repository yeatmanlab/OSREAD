package appforliteracy

import appforliteracy.moduleInputDomains.ModuleOutput
import org.grails.web.json.JSONObject


class WriteModuleOutputToDBService {
    JSONObject output

    WriteModuleOutputToDBService(JSONObject output) {
        this.output = output
    }

    String writeToDB () {
        JSONObject newOutput = parseJSON()
        List<String> keys = new ArrayList<>()
        keys.add("headers")
        keys.add("valueRows")
        keys.add("type")
        WriteModuleDataToDBService writer = new WriteModuleDataToDBService(newOutput, keys)
        String id = writer.writeToDB()
        ModuleOutput.list().size()
        //TODO: Save output ID in Module
    }

    private JSONObject parseJSON () {
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
