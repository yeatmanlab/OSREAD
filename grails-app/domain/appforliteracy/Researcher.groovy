package appforliteracy

class Researcher extends User {
    
    String position
    Learner[] learners
    
    static constraints = {
        position blank: false
        learners blank: false, nullable: true
    }
}