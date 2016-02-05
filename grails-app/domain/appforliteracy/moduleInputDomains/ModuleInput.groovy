package appforliteracy.moduleInputDomains

import appforliteracy.moduleInputDomains.ModuleData

abstract class ModuleInput extends ModuleData {

    static constraints = {
        name(unique: true)
    }

    String name

}
