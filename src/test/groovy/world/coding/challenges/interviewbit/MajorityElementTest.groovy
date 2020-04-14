package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class MajorityElementTest extends Specification {
    @Shared
    private static MajorityElement solution = new MajorityElement()

    def "MajorityElement"() {
        expect:
        solution.majorityElement(input) == expectedOut
        solution.majorityElementEditorial(input) == expectedOut

        where:
        input                 || expectedOut
        [1, 2, 2, 2, 2, 3, 3] || 2
        [2, 2, 1, 3, 3, 2, 2] || 2
    }
}

