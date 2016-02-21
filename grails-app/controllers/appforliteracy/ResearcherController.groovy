package appforliteracy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class ResearcherController extends grails.plugin.springsecurity.ui.UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService

    @Secured('ROLE_RESEARCHER')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Researcher.list(params), model:[researcherCount: Researcher.count()]
    }


    @Secured('ROLE_RESEARCHER')
    def show(Researcher researcher) {
        respond researcher
    }
    
    @Secured('ROLE_RESEARCHER')
    def assign() {
        redirect(controller: "fileInput", action: "list", id: params.learnerID)
    }

    @Secured('ROLE_RESEARCHER')
    def progress() {
        redirect(controller: "fileOutput", action: "output", id: params.learnerID)
    }
    
    @Secured('ROLE_RESEARCHER')
    def home() {
        Researcher researcher = springSecurityService.currentUser
        //def firstName = researcher.firstName
        println(researcher)
        println(researcher.getLearners())
        [fname:researcher.firstName, learners:researcher.getLearners()]
    }
    
    @Secured('ROLE_RESEARCHER')
    def editLearners(){
        def researcher = springSecurityService.currentUser
        render(view:"editLearners.gsp")
    }

    @Secured('ROLE_RESEARCHER')
    def viewProgress(){
        render(view:"../learner/viewProgress.gsp", model:[id:params.id])
    }
    
    @Secured('ROLE_RESEARCHER')
    def editModules(){
        render(view:"editModules.gsp")
    }
    
    @Secured('ROLE_RESEARCHER')
    def myAccount(){
        render('Under construction')
    }

    @Transactional
    def delete(Researcher researcher) {

        if (researcher == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        researcher.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'researcher.label', default: 'Researcher'), researcher.userID])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'researcher.label', default: 'Researcher'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}