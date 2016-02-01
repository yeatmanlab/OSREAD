package appforliteracy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AdminController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Admin.list(params), model:[adminCount: Admin.count()]
    }

    def show(Admin admin) {
        respond admin
    }

    def create() {
        respond new Admin(params)
    }

    @Transactional
    def save(Admin admin) {
        if (admin == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (admin.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond admin.errors, view:'create'
            return
        }

        admin.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'admin.label', default: 'Admin'), admin.id])
                redirect admin
            }
            '*' { respond admin, [status: CREATED] }
        }
    }

    def edit(Admin admin) {
        respond admin
    }

    @Transactional
    def update(Admin admin) {
        if (admin == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (admin.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond admin.errors, view:'edit'
            return
        }

        admin.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'admin.label', default: 'Admin'), admin.id])
                redirect admin
            }
            '*'{ respond admin, [status: OK] }
        }
    }

    @Transactional
    def delete(Admin admin) {

        if (admin == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        admin.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'admin.label', default: 'Admin'), admin.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'admin.label', default: 'Admin'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
