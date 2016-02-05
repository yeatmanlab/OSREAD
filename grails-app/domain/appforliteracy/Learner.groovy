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
        /*researcher validator: {
            if (!Researcher.list().contains(researcher)) return ['entryMissing']
        }*/
        moduleIDs nullable: true
    }
    
}
