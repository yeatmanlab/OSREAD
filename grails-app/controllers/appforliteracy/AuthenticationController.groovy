package appforliteracy

class AuthenticationController {

    def auth() {
        User r = User.findByEmail(params.email)
        if (r.password == params.password){
            if (r instanceof Researcher) {
                redirect(controller: "researcher", action: "home", id: r.userID)
            } else {
                redirect(controller: "learner", action: "home", id: r.userID)
            }
        } else {
            render(view:"../login/login.gsp") //TODO: FIX
        }
    }
}
