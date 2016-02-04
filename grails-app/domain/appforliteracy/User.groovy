package appforliteracy

abstract class User {

    String id = UUID.randomUUID().toString()
    String email
    String password
    String lastName
    String firstName
    
    static constraints = {
        id unique: true
        email blank: false, unique: true
        password blank: false
        lastName blank: false
        firstName blank: false
    }
}
