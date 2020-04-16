package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class LastStoneWeightTest extends Specification {
    @Shared
    private static LastStoneWeight solution = new LastStoneWeight()

    def "LastStoneWeight"() {
        expect:
        solution.lastStoneWeight(input as int[]) == expectedOut

        where:
        input              || expectedOut
        []                 || 0
        [13]               || 13
        [13, 12]           || 1
        [13, 10, 1]        || 2
        [2, 7, 4, 1, 8, 1] || 1
    }
}

