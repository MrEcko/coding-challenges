package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class MaximumSubarrayTest extends Specification {
    @Shared
    private static MaximumSubarray solution = new MaximumSubarray()

    def "MaximumSubarray"() {
        expect:
        solution.maxSubArray(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [-2,1,-3,4,-1,2,1,-5,4] || 6
    }
}

