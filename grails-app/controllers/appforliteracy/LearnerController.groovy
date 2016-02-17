package appforliteracy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class LearnerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    @Secured('ROLE_RESEARCHER')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Learner.list(params), model:[learnerCount: Learner.count()]
    }

    def show(Learner learner) {
        respond learner
    }

    def create() {
        respond new Learner(params)
    }

    @Transactional
    def save(Learner learner) {
        if (learner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (learner.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond learner.errors, view:'create'
            return
        }

        learner.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'learner.label', default: 'Learner'), learner.id])
                redirect learner
            }
            '*' { respond learner, [status: CREATED] }
        }
    }

    def edit(Learner learner) {
        respond learner
    }

    @Transactional
    def update(Learner learner) {
        if (learner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (learner.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond learner.errors, view:'edit'
            return
        }

        learner.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'learner.label', default: 'Learner'), learner.id])
                redirect learner
            }
            '*'{ respond learner, [status: OK] }
        }
    }

    @Transactional
    def delete(Learner learner) {

        if (learner == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        learner.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'learner.label', default: 'Learner'), learner.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'learner.label', default: 'Learner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
