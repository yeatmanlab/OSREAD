package appforliteracy

class Admin extends User {
    
    String userName
    
    static constraints = {
        userName blank: false, unique: true
    }
}
