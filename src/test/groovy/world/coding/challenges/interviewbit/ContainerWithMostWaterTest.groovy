package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class ContainerWithMostWaterTest extends Specification {
    @Shared
    private static ContainerWithMostWater solution = new ContainerWithMostWater()

    def "ContainerWithMostWater"() {
        expect:
        solution.maxArea(input as ArrayList<Integer>) == expectedOut

        where:
        input        || expectedOut
        [1]          || 0
        [1, 5, 4, 3] || 6
    }
}

