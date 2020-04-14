package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class MaxSumContiguousSubarrayTest extends Specification {
    @Shared
    private static MaxSumContiguousSubarray solution = new MaxSumContiguousSubarray()

    def "MaxSumContiguousSubarray"() {
        expect:
        solution.maxSubArray(input) == expectedOut

        where:
        input                           || expectedOut
        [10]                            || 10
        [1, 2, 3, 4, -10]               || 10
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
    }
}

