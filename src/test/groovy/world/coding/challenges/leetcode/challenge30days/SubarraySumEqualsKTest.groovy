package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class SubarraySumEqualsKTest extends Specification {
    @Shared
    private static SubarraySumEqualsK solution = new SubarraySumEqualsK()

    def "SubarraySumEqualsK"() {
        expect:
        solution.subarraySum(input as int[], k) == expectedOut

        where:
        input     | k || expectedOut
        [1, 1, 1] | 2 || 2
    }
}

