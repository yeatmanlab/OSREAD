package appforliteracy

abstract class User {

    String userID = UUID.randomUUID().toString()
    String email
    String password
    String lastName
    String firstName
    
    static constraints = {
        userID unique: true
        email blank: false, unique: true
        password blank: false
        lastName blank: false
        firstName blank: false
    }
}
