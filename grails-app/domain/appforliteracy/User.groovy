package appforliteracy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='email')
@ToString(includes='email', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService
    
    //String userID = UUID.randomUUID().toString()
    String email
    String password
    boolean enabled = true
    String lastName
    String firstName
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    User(String email, String password, String lastName, String firstName) {
	this.email = email
	this.password = password
        this.lastName = lastName
        this.firstName = firstName
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
	email blank: false, unique: true
	password blank: false
        lastName nullable: true
        firstName nullable: true
    }

    static mapping = {
	password column: '`password`'
        userID unique: true
        email blank: false, unique: true
        password blank: false
    }
}
