package appforliteracy

import metafunctionality.Module
import appforliteracy.User

class Learner {
    
    User user
    Date dateOfBirth
    String disability
    String researcherID
    static hasMany = [moduleIDs: String]
    List moduleIDs
    
    Learner(User user) {
        this.user = user
	//this.email = user.email
	//this.password = user.password
        //this.lastName = user.lastName
        //this.firstName = user.firstName
    }
    
    static constraints = {
        dateOfBirth nullable: true
        disability nullable: true
        researcherID nullable: true
        moduleIDs nullable: true
    }

    def getResearcher () {
        return Researcher.findById(researcherID)
    }

    def getModules () {
        List<Module> modules = new ArrayList<>()
        for (modID in moduleIDs) {
            modules.add(Module.findByModuleId(modID))
        }
        return modules
    }
}
