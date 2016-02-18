package appforliteracy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

<<<<<<< HEAD
@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService
    
=======
    String userID = UUID.randomUUID().toString()
>>>>>>> master
    String email
    String password
    boolean enabled = true
    String lastName
    String firstName
    //String id = UUID.randomUUID().toString()
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    boolean isResearcher

    User(String email, String password) {
	this()
	this.email = email
	this.password = password
    }

    Set<Role> getAuthorities() {
	UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
	encodePassword()
    }

    def beforeUpdate() {
	if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
	password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password   
    }

    static transients = ['springSecurityService']

    static constraints = {
<<<<<<< HEAD
	email blank: false, unique: true
	password blank: false
        lastName nullable: true
        firstName nullable: true
    }

    static mapping = {
	password column: '`password`'
=======
        userID unique: true
        email blank: false, unique: true
        password blank: false
        lastName blank: false
        firstName blank: false
>>>>>>> master
    }
}
