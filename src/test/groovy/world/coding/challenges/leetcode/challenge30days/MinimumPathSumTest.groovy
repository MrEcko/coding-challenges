package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class MinimumPathSumTest extends Specification {
    @Shared
    private static MinimumPathSum solution = new MinimumPathSum()

    def "MinimumPathSum"() {
        expect:
        solution.minPathSum(input as int[][]) == expectedOut

        where:
        input                             || expectedOut
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] || 7
        [[1, 3, 1], [1, 5, 1], [4, 2, 1]] || 7
    }
}

