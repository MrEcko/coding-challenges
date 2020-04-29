package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class LeftmostColumnWithAtLeastAOneTest extends Specification {
    @Shared
    private static LeftmostColumnWithAtLeastAOne solution = new LeftmostColumnWithAtLeastAOne()

    def "LeftmostColumnWithAtLeastAOne"() {
        expect:
        solution.leftMostColumnWithOne(new LeftmostColumnWithAtLeastAOne.BinaryMatrix(input as int[][])) == expectedOut

        where:
        input                                      || expectedOut
        [[0, 0], [1, 1]]                           || 0
        [[0, 0], [0, 1]]                           || 1
        [[0, 0], [0, 0]]                           || -1
        [[0, 0, 0, 1], [0, 0, 1, 1], [0, 1, 1, 1]] || 1
    }
}

