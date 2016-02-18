package appforliteracy

import metafunctionality.Module

class Learner extends User {

    Date dateOfBirth
    String disability
    String researcherID
    static hasMany = [moduleIDs: String]
    List moduleIDs
    
    static constraints = {
        dateOfBirth blank: false
        disability blank: false
        researcherID blank: false
        /*researcher validator: {
            if (!Researcher.list().contains(researcher)) return ['entryMissing']
        }*/
        moduleIDs nullable: true
    }

    def getResearcher () {
        return Researcher.findByUserID(researcherID)
    }

    def getModules () {
        List<Module> modules = new ArrayList<>()
        for (modID in moduleIDs) {
            modules.add(Module.findByModuleId(modID))
        }
        return modules
    }
}
