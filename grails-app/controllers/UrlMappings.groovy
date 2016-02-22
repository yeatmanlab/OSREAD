class UrlMappings {
    
    def springSecurityService

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        

        "/"(view:"login/auth")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
