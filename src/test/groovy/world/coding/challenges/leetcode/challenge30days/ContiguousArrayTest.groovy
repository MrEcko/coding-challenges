package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class ContiguousArrayTest extends Specification {
    @Shared
    private static ContiguousArray solution = new ContiguousArray()

    def "ContiguousArray"() {
        expect:
        solution.findMaxLength(input as int[]) == expectedOut

        where:
        input                          || expectedOut
        [0, 1]                         || 2
        [0, 1, 0]                      || 2
        [0, 0, 0, 0, 1, 1, 1, 1]       || 8
        [0, 0, 0, 0, 1, 1, 1, 1, 0]    || 8
        [1, 0, 0, 0, 0, 1, 1, 1, 1]    || 8
        [1, 1, 0, 0, 0, 0, 1, 1]       || 8
        [0, 0, 1, 1, 1, 1, 0, 0]       || 8
        [0, 0, 1, 1, 1, 0, 1, 1, 0, 0] || 10

    }
}

