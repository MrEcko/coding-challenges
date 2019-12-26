package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class MaxCountersTest extends Specification {

    @Shared
    private MaxCounters maxCounters = new MaxCounters();

    @Unroll
    def "MaxCounters"() {
        expect:
        maxCounters.solution(N, input as int[]) == expectedOutput

        where:
        input                 | N || expectedOutput
        [3, 4, 4, 6, 1, 4, 4] | 5 || [3, 2, 2, 4, 2]

    }
}
