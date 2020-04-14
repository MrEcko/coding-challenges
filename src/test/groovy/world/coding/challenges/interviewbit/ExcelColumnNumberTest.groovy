package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class ExcelColumnNumberTest extends Specification {
    @Shared
    private static ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber()

    def "ExcelColumnNumber"() {
        expect:
        excelColumnNumber.titleToNumber(input) == expectedOut

        where:
        input || expectedOut
        "A"   || 1
        "Z"   || 26
        "AA"  || 27
    }
}

