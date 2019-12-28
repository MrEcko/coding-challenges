package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class MaxProductOfThreeTest extends Specification {

    @Shared
    private MaxProductOfThree maxProductOfThree = new MaxProductOfThree()

    def "MaxProductOfThree"() {

        expect:
        maxProductOfThree.solution(input as int[]) == expectedOut

        where:
        input                      || expectedOut
        [-3, 1, 2, -2, 5, 6]       || 60
        [-1000, -1000, 1, 0]       || 1000000
        [-1000, -1000, 1, 0, 1000] || 1000000000
        [1, 0, 5, 1000]            || 5000
    }
}
