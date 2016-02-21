package appforliteracy

import appforliteracy.User

class Researcher extends User {
    
    User user
    String position
    static hasMany = [learnerIDs: Long]
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
        println("outside")
        for (learnerID in learnerIDs) {
            Learner learner = Learner.findById(learnerID)
            println(learner)
            learners.add(learner)
        }
        return learners
    }
}