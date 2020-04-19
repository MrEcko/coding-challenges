package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class ProductOfArrayExceptSelfTest extends Specification {
    @Shared
    private static ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf()

    def "ProductOfArrayExceptSelf"() {
        expect:
        solution.productExceptSelf(input as int[]) == expectedOut as int[]

        where:
        input        || expectedOut
        [1, 2, 3, 4] || [24, 12, 8, 6]
    }
}

