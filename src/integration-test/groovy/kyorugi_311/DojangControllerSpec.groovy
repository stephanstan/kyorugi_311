package kyorugi_311

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

    void "test something"() {
        when:"The home page is visited"
            go 'http://localhost:8080/kyorugi/'

        then:"The title is correct"
    //    	$('title').text() == "\nWelcome to Grails"
        $('title').text() == ""
    }
}
