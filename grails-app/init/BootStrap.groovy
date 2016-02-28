import kyorugi.Dojang

class BootStrap {

    def init = { servletContext ->
        new Dojang(name: "Red Phoenix").save()
        new Dojang(name: "Precision TaeKwondo").save()
    }
    def destroy = {
    }
}
