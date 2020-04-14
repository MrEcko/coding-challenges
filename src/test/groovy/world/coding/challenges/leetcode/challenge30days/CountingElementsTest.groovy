package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class CountingElementsTest extends Specification {
    @Shared
    private static CountingElements solution = new CountingElements()

    def "CountingElements"() {
        expect:
        solution.countElements(input as int[]) == expectedOut

        where:
        input                    || expectedOut
        [1, 2, 3]                || 2
        [1, 1, 3, 3, 5, 5, 7, 7] || 0
        [1, 3, 2, 3, 5, 0]       || 3
        [1, 1, 2, 2]             || 2
    }
}

