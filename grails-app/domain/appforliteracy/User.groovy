package appforliteracy

class User {
    
    String email
    String password
    String lastName
    String firstName
    
    static constraints = {
        email blank: false, unique: true
        password blank: false
        lastName blank: false
        firstName blank: false
    }
}
