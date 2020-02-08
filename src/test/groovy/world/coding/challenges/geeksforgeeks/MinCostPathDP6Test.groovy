package world.coding.challenges.geeksforgeeks;

import spock.lang.Shared;
import spock.lang.Specification;

class MinCostPathDP6Test extends Specification {
    @Shared
    private static MinCostPathDP6 solution = new MinCostPathDP6()

    def "MinCostPathDP6"() {
        expect:
        solution.minCostDP(cost as int[][], m, n) == expectedOut
        solution.minCost(cost as int[][], m, n) == expectedOut


        where:
        cost                              | m | n || expectedOut
        [[1, 2, 3], [4, 8, 2], [1, 5, 3]] | 2 | 2 || 8
        [[1, 2, 3], [3, 8, 2], [1, 0, 3]] | 2 | 2 || 7
    }
}

