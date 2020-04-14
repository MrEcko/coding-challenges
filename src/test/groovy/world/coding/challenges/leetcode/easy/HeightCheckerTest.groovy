package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class HeightCheckerTest extends Specification {
    @Shared
    private static HeightChecker solution = new HeightChecker()

    def "HeightChecker"() {
        expect:
        solution.heightChecker(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [1, 1, 4, 2, 1, 3] || 3
    }
}

