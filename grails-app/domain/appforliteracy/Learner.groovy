package appforliteracy

import metafunctionality.Module
import appforliteracy.User

class Learner extends User {
    
    //User user
    Date dateOfBirth
    String disability
    long researcherID
    static hasMany = [moduleIDs: String]
    List moduleIDs

    /*Learner(User user) {
        //this.user = user
    }*/
    Learner(String email, String password, String lastName, String firstName) {
	this.email = email
	this.password = password
        this.lastName = lastName
        this.firstName = firstName
    }
    
    Learner() {
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
