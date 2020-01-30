package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class NumberOfRecentCallsTest extends Specification {
    @Shared
    private static NumberOfRecentCalls solution = new NumberOfRecentCalls()

    def "NumberOfRecentCalls"() {
        expect:
        pings.size() == expectedOut.size()
        for (int i = 0; i < pings.size(); i++) {
            solution.ping(pings.get(i)) == expectedOut.get(i);
        }


        where:
        pings                || expectedOut
        [1, 100, 3001, 3002] || [1, 2, 3, 3]
    }
}

