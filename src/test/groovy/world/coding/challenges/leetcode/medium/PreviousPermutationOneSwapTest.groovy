package world.coding.challenges.leetcode.medium;

import spock.lang.Shared;
import spock.lang.Specification
import spock.lang.Unroll;

class PreviousPermutationOneSwapTest extends Specification {
    @Shared
    private static PreviousPermutationOneSwap solution = new PreviousPermutationOneSwap()

    @Unroll
    def "PreviousPermutationOneSwap"() {
        expect:
        solution.prevPermOpt1(input as int[]) == expectedOut as int[]

        where:
        input        || expectedOut
//        [3, 2, 1]    || [3, 1, 2]
        [3, 2, 1, 1] || [3, 1, 2, 1]
//        [1, 1, 5]          || [1, 1, 5]
//        [1, 9, 4, 6, 7]    || [1, 7, 4, 6, 9]
//        [3, 1, 1, 3]       || [1, 3, 1, 3]
//        [9, 2, 1, 3, 5, 8] || [9, 1, 2, 3, 5, 8]
    }
}

