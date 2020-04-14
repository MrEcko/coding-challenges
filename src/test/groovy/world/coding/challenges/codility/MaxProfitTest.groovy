package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class MaxProfitTest extends Specification {
    @Shared
    private static MaxProfit maxProfit = new MaxProfit()

    def "MaxProfit"() {
        expect:
        maxProfit.solution(input as int[]) == expectedOut

        where:

        input                                      || expectedOut
        [23171, 21011, 21123, 21366, 21013, 21367] || 356
        []                                         || 0
        [11]                                       || 0
        [0, 1]                                     || 1
        [5, 4, 3, 2, 1]                            || 0
        [1, 2, 3, 4, 5]                            || 4
        [30, 100, 21, 25, 25, 23]                  || 70
    }
}

