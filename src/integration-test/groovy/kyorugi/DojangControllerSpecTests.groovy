package kyorugi

import grails.test.mixin.integration.Integration
import grails.transaction.*
import kyorugi.Dojang
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class DojangControllerSpecTests extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test kyorugi homepage"() {
        when: "The home page is visited"
        go 'http://localhost:8080/kyorugi/'

        then:
        "The title is correct"
        /*  	$('title').text() == "Welcome to Grails" */
        println($('title').text())
        assert title == "Welcome to Grails"
        /*$('title').text() == "" */
    }

    void "first geb test"() {
        when: "visit gebish.org"
        go "http://gebish.org"

        then:
        assert title == "Geb - Very Groovy Browser Automation"

        $("#sidebar .sidemenu a", text: "jQuery-like API").click()

        assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"]
        assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
    }

    void "save a Dojang"() {
        given: "A brand new user"

        def master = new Dojang(name: 'Stephan Stan')

        when: "The Dojang is saved"
        master.save()

        then: "new entry is saved and can be found in the database"
        master.errors.errorCount == 0
        master.id != null
        println(master.name)
    }

    void "save a new Dojang and examine all the Dojangs in the system"() {
        given: "A brand new user"

        def master = new Dojang(name: 'Stephan Stan')

        when: "The Dojang is saved"
        master.save()

        then: "new entry is saved and can be found in the database"
        master.errors.errorCount == 0
        master.id != null
       // println(master.name)

       // def List list
       //  = Dojang.findAll()

        println "count of Dojang list: " + Dojang.findAll().size()
        assert Dojang.findAll().size() == 3

        println Dojang.findAll().get(0).name
        println Dojang.findAll().get(1).name
        println Dojang.findAll().get(2).name

        // order is not guaranteed
//        assert Dojang.findAll().get(0).name == "Red Phoenix"
  //      assert Dojang.findAll().get(0).name == "Precision Taekwondo"
    //    assert Dojang.findAll().get(0).name == "Stephan Stan"
    }


    void "Save a new Dojang and examine all the Dojangs in the system"() {
        given: "A brand new user"

        def master = new Dojang(name: 'Stephan Stan')

        when: "The Dojang is saved"
        master.save()

        then: "new entry is saved and can be found in the database"
        master.errors.errorCount == 0
        master.id != null
        println(master.name)

        // def List list
        //  = Dojang.findAll()

        println "count of Dojang list: " + Dojang.list().size()
        assert Dojang.list().size() == 3

     //   println Doijang.findAll().get(0).name
      //  println Dojang.findAll().get(1).name
      //  println Dojang.findAll().get(2).name

 //       assert Dojang.findAll().get(0).name == "Red Phoenix"
   //     assert Dojang.findAll().get(0).name == "Precision Taekwondo"
     //   assert Dojang.findAll().get(0).name == "Stephan Stan"
    }
}
