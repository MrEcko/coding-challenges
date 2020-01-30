package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class ArrayPartitionTest extends Specification {

    @Shared
    private static ArrayPartition solution = new ArrayPartition()

    def "ArrayPartition"() {
        expect:
        solution.arrayPairSum(input as int[]) == expectedOut

        where:
        input        || expectedOut
        [1, 4, 3, 2] || 4
    }
}

