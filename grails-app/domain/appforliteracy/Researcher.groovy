package appforliteracy

class Researcher extends User {
    
    String position
    static hasMany = [learnerIDs: String]
    List learnerIDs
    
    static constraints = {
        position blank: false
        learnerIDs blank: false, nullable: true
    }
}