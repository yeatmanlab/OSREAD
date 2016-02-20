package appforliteracy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class ResearcherController extends grails.plugin.springsecurity.ui.UserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

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
        Researcher r = Researcher.user.getCurrentUser(params.email)
        //[fname:r.firstName, learners:r.getLearners()]
        [fname:r.user.firstName]
    }
    
    @Secured('ROLE_RESEARCHER')
    def editLearners(){
        Researcher r = Researcher.user.findByEmail(params.email)
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

}
