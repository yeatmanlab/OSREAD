package appforliteracy

class Researcher extends User {
    
    String position
    static hasMany = [learnerIDs: String]
    List learnerIDs
    
    Researcher(String email, String password) {
	this()
	this.email = email
	this.password = password
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