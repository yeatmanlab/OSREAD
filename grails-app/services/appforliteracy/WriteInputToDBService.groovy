package appforliteracy

import grails.transaction.Transactional
import org.grails.web.json.JSONObject
import org.springframework.orm.hibernate3.HibernateTemplate
import org.hibernate.SessionFactory

//@Transactional
class WriteInputToDBService {


    final DOMAINPACKAGE = "appforliteracy."

    JSONObject input
    List<String> keys

    WriteInputToDBService(JSONObject input, List<String> keys) {
        this.input = input
        this.keys = keys
    }

    def writeToDB () {

        ModuleInput data = Class.forName(DOMAINPACKAGE + input.type).newInstance()
        for (key in keys) {
            data[key] = input[key]
        }
        data.save(flush: true)

    }



}
