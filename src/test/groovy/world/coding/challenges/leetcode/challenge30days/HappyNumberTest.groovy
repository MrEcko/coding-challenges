package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class HappyNumberTest extends Specification {
    @Shared
    private static HappyNumber solution = new HappyNumber()

    def "HappyNumber"() {
        expect:
        solution.isHappy(input) == expectedOut

        where:
        input   || expectedOut
        1111111 || true
        1       || true
        2       || false
        19      || true
    }
}

