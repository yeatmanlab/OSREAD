package appforliteracy

class Researcher extends User {
    
    String position
    static hasMany = [learnerIDs: String]
    List learnerIDs
    
    static constraints = {
        position nullable: true
        learnerIDs nullable: true
    }
}