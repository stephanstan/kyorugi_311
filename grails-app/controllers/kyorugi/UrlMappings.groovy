package kyorugi

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/" ( controller:'dojang', action:'index' ) // Here i have changed the desired   action to show the desired page while running the application
//        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/static/"(redirect:"/index.html")
    }
}
