package world.coding.challenges.interviewbit

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ExcelColumnTitleTest extends Specification {
    @Shared
    private static ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle()

    @Unroll
    def "ExcelColumnNumber"() {
        expect:
        excelColumnTitle.convertToTitle(input) == expectedOut

        where:
        input  || expectedOut
        1      || "A"
        26     || "Z"
        27     || "AA"
        28     || "AB"
        943566 || "BAQTZ"

    }
}

