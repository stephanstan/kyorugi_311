package kyorugi

import com.stephanstan.pontus.excel.ExcelHelper
import grails.test.mixin.TestFor
import spock.lang.Specification
import com.stephanstan.pontus.excel.ExcelFileLaboratory

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Dojang)
class ExcelCreationSpec extends Specification {

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

    def "poi advocate - write xlsx with blinger features - name worksheet Dojang"(){

        setup:
        ExcelFileLaboratory lab = new ExcelFileLaboratory()
        when:
        def result = lab.createDojangBlinger_02()

        then:

        result == true
    }

    /**
     * Sheetname - Dojang
     * has
     * columns: Ignore Row, Name
     * top row - white font, black background
     */
    def "poi advocate - create a blank Dojang - name worksheet Dojang"(){

        setup:
        ExcelFileLaboratory lab = new ExcelFileLaboratory()
        when:
        def result = ExcelHelper.createAnEmptyDojangBlinger()

        then:
        assert result.getSheet("Dojang").getRow(0).getCell(0).getStringCellValue() == "Ignore Row"
        assert result.getSheet("Dojang").getRow(0).getCell(1).getStringCellValue() == "Name"
    }
}

