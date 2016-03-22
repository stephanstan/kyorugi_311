package kyorugi

import grails.test.mixin.TestFor
import spock.lang.Specification

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.stephanstan.pontus.excel.Library;
import geb.Browser

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Dojang)
class DojangSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == true
    }

    def "first crack at poi - write xlsx file"(){

        setup:
        Library lib = new Library()
        when:
        def result = lib.createXlsxFile()

        then:

        result == true

    }

    def "next crack at poi - write xlsx with ExcelHelper"(){

        setup:
        Library lib = new Library()
        when:
        def result = lib.createXlsxFile_01()

        then:

        result == true
    }

    def "first geb test"(){
        Browser.drive {
            go "http://gebish.org"

            assert title == "Geb - Very Groovy Browser Automation"

            $("#sidebar .sidemenu a", text: "jQuery-like API").click()

            assert $("#main h1")*.text() == ["Navigating Content", "Form Control Shortcuts"]
            assert $("#sidebar .sidemenu a", text: "jQuery-like API").parent().hasClass("selected")
        }
    }
}

