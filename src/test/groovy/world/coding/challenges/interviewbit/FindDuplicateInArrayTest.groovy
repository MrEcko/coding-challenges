package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class FindDuplicateInArrayTest extends Specification {
    @Shared
    private static FindDuplicateInArray solution = new FindDuplicateInArray()

    def "FindDuplicateInArray"() {
        expect:
        solution.repeatedNumber(input) == expectedOut

        where:
        input              || expectedOut
        []                 || -1
        [1]                || -1
        [1, 2, 3]          || -1
        [1, 2, 2, 2, 3, 3] || 2
        [1, 2, 3, 1]       || 1
    }
}

