package appforliteracy

class Learner extends User {
    
    String patientId
    Date dateOfBirth
    String disability
    Researcher researcher //researcher object or just id?
    Module[] modules
    
    static constraints = {
        patientId blank: false, unique: true
        dateOfBirth blank: false
        disability blank: false
        researcher blank: false
        /*researcher validator: {
            if (!Researcher.list().contains(researcher)) return ['entryMissing']
        }*/
        modules nullable: true
    }
    
}
