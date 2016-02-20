package appforliteracy

import appforliteracy.User

class Researcher {
    
    User user
    String position
    static hasMany = [learnerIDs: String]
    List learnerIDs
    
    Researcher(User user) {
        this.user = user
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