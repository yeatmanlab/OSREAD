package appforliteracy

import metafunctionality.Module
import appforliteracy.User

/*
    Class structure for learner (student).
 */

class Learner extends User {

    Date dateOfBirth
    String disability
    static hasMany = [moduleIDs: String]
    List moduleIDs

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
        moduleIDs nullable: true
    }

    def getModules () {
        List<Module> modules = new ArrayList<>()
        for (modID in moduleIDs) {
            modules.add(Module.findByModuleId(modID))
        }
        return modules
    }
}
