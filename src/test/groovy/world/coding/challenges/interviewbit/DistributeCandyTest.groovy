package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class DistributeCandyTest extends Specification {
    @Shared
    private static DistributeCandy solution = new DistributeCandy()

    def "DistributeCandy"() {
        expect:
        solution.candyEditorial(input as ArrayList<Integer>) == expectedOut

        where:
        input        || expectedOut
        [1, 2]       || 3
        [1, 5, 2, 1] || 7
    }
}

