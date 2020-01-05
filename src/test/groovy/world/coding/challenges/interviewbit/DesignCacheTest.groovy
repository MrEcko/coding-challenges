package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class DesignCacheTest extends Specification {
    @Shared
    private static DesignCache designCache = new DesignCache()

    def "DesignCache"() {
        expect:
        designCache.solution(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [1, 2, 2, 2, 3, 3] || 3
    }
}

