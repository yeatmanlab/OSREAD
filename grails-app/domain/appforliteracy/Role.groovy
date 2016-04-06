package appforliteracy

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/*
    Class structure for role. Required for the log-in system.
 */

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

    private static final long serialVersionUID = 1

    String authority

    Role(String authority) {
        this()
        this.authority = authority
    }

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }
}
