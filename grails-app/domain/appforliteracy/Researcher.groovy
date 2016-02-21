package appforliteracy

import appforliteracy.User

class Researcher extends User {
    
    User user
    String position
    static hasMany = [learnerIDs: String]
    List learnerIDs

    /*Researcher(User user) {
        this.user = user
    }*/
    Researcher(String email, String password, String lastName, String firstName) {
	this.email = email
	this.password = password
        this.lastName = lastName
        this.firstName = firstName
    }
    
    Researcher() {
    }
    
    static constraints = {
        position nullable: true
        learnerIDs nullable: true
    }

    def getLearners () {
        List<Learner> learners = new ArrayList<>()
        for (learnerID in learnerIDs) {
            learners.add(Learner.findByUserID(learnerID))
        }
        return learners
    }
}