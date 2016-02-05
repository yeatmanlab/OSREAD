package appforliteracy

import appforliteracy.moduleInputDomains.ModuleData
import org.grails.web.json.JSONObject


class WriteModuleDataToDBService {
    final DOMAINPACKAGE = "appforliteracy.moduleInputDomains."

    JSONObject data
    List<String> keys

    WriteModuleDataToDBService(JSONObject input, List<String> keys) {
        this.data = input
        this.keys = keys
    }

    String writeToDB () {
        ModuleData result = Class.forName(DOMAINPACKAGE + data.type).newInstance()
        for (key in keys) {
            result[key] = this.data[key]
        }
        result.save(flush: true)
        return result.moduleDataID
    }



}
