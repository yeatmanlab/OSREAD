package appforliteracy

class Learner extends User {

    Date dateOfBirth
    String disability
    String researcherID
    static hasMany = [moduleIDs: String]
    List moduleIDs
    
    static constraints = {
        dateOfBirth blank: false
        disability blank: false
        researcherID blank: false
        moduleIDs nullable: true
    }
    
}
