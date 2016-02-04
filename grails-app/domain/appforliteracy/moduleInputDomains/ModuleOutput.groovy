package appforliteracy.moduleInputDomains

import appforliteracy.moduleInputDomains.ModuleData

class ModuleOutput extends ModuleData {

    static constraints = {
    }



    static hasMany = [headers: String, valueRows: String]
    List valueRows
    List headers
}
