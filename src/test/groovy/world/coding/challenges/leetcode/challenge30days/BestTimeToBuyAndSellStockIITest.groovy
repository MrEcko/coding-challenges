package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class BestTimeToBuyAndSellStockIITest extends Specification {
    @Shared
    private static BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII()

    def "BestTimeToBuyAndSellStockII "() {
        expect:
        solution.maxProfit(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [6, 1, 3, 2, 4, 7] || 7
        [7, 1, 5, 3, 6, 4] || 7
        [1, 2, 3, 4, 5]    || 4
        [7, 6, 4, 3, 1]    || 0
    }
}

