package appforliteracy
import grails.plugin.springsecurity.*

class AuthenticationController {

    def auth() {
        User r = springSecurityService.currentUser
        if (r.password == params.password){
            if (r instanceof Researcher) {
                redirect(controller: "researcher", action: "home", id: r.getId())
            } else {
                redirect(controller: "learner", action: "home", id: r.getId())
            }
        } else {
            render(view:"../login/auth.gsp") //TODO: FIX
        }
    }
}
