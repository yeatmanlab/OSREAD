package appforliteracy

class LoginController {

    def index() {
        render(view:'login.gsp')
    }

    def register(){
        render(view:'register.gsp')
    }
}
