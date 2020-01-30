package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class Maximum69Test extends Specification {
    @Shared
    private static Maximum69 solution = new Maximum69()

    def "Maximum69"() {
        expect:
        solution.maximum69Number(input) == expectedOut

        where:
        input || expectedOut
        9669  || 9969
        9996  || 9999
        9999  || 9999
    }
}

