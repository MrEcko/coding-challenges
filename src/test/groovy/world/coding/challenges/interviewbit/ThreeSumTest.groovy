package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class ThreeSumTest extends Specification {
    @Shared
    private static ThreeSum threeSum = new ThreeSum()

    def "ThreeSum"() {
        expect:
        threeSum.threeSumClosest(input as ArrayList<Integer>, target) == expectedOut

        where:
        input          | target || expectedOut
        [-1, 2, 1, -4] | 1      || 2
    }
}

