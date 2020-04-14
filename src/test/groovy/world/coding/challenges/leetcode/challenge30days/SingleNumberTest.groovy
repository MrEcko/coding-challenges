package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class SingleNumberTest extends Specification {
    @Shared
    private static SingleNumber solution = new SingleNumber()

    def "SingleNumber"() {
        expect:
        solution.singleNumber(input as int[]) == expectedOut

        where:
        input           || expectedOut
        [2, 2, 1]       || 1
        [4, 1, 2, 1, 2] || 4
    }
}

