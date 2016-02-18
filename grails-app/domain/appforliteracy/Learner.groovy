package appforliteracy

import metafunctionality.Module

class Learner extends User {

    Date dateOfBirth
    String disability
    String researcherID
    static hasMany = [moduleIDs: String]
    List moduleIDs
    
    Learner(String email, String password) {
	this()
	this.email = email
	this.password = password
    }
    
    static constraints = {
        dateOfBirth nullable: true
        disability nullable: true
        researcherID nullable: true
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
