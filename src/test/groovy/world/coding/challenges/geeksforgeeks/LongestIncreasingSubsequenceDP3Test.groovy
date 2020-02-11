package world.coding.challenges.geeksforgeeks;

import spock.lang.Shared;
import spock.lang.Specification;

class LongestIncreasingSubsequenceDP3Test extends Specification {
    @Shared
    private static LongestIncreasingSubsequenceDP3 solution = new LongestIncreasingSubsequenceDP3()

    def "LongestIncreasingSubsequenceDP3"() {
        expect:
        solution.lis(input as int[], input.size()) == expectedOut
        solution.lisDynamic(input as int[], input.size()) == expectedOut
        LongestIncreasingSubsequenceDP3.LIS(input as int[]) == expectedOut

        where:
        input                  || expectedOut
        [3, 10, 2, 1, 20]      || 3
        [3, 2]                 || 1
        [50, 3, 10, 7, 40, 80] || 4
    }
}

