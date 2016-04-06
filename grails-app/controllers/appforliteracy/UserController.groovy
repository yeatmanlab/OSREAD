package appforliteracy

/*
    Required for spring security log-in authentication
 */

class UserController extends grails.plugin.springsecurity.ui.UserController {
    def springSecurityService

    def auth() {
        User r = springSecurityService.currentUser

        if (r instanceof Researcher) {
            redirect(controller: "researcher", action: "home", id: r.getId())
        } else {
            redirect(controller: "learner", action: "home", id: r.getId())
        }

    }
}