package kyorugi_311

import geb.Browser
import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class DojangControllerSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test kyorugi homepage"() {
        when:"The home page is visited"
            go 'http://localhost:8080/kyorugi/'

        then:"The title is correct"
        /*  	$('title').text() == "Welcome to Grails" */
        $('title').text() == ""
    }

    void "first geb test"(){
       when: "visit gebish.org"
            go "http://gebish.org"

       then:
            assert title == "Geb - Very Groovy Browser Automation"

            $("#sidebar .sidemenu a", text: "jQuery-like API").click()

            assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"]
            assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
        }
    }
