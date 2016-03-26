package kyorugi

import grails.test.mixin.TestFor
import spock.lang.Specification
import com.stephanstan.pontus.excel.ExcelFileLaboratory

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
        ExcelFileLaboratory  lab = new ExcelFileLaboratory()
        when:
        def result = lab.createXlsxFile()

        then:

        result == true

    }

    def "next crack at poi - write xlsx with ExcelHelper"(){

        setup:
        ExcelFileLaboratory lab = new ExcelFileLaboratory()
        when:
        def result = lab.createXlsxFile_01()

        then:

        result == true
    }

    def "poi advocate - write xlsx with ExcelHelper - name worksheet Dojang"(){

        setup:
        ExcelFileLaboratory lab = new ExcelFileLaboratory()
        when:
        def result = lab.createDojangBlinger_01()

        then:

        result == true
    }


}

