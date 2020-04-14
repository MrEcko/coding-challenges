package world.coding.challenges.interviewbit;

import spock.lang.Shared;
import spock.lang.Specification;

class GasStationTest extends Specification {
    @Shared
    private static GasStation solution = new GasStation()

    def "GasStation"() {
        expect:
        solution.canCompleteCircuit(A, B) == expectedOut
        solution.canCompleteCircuitEditorial(A, B) == expectedOut

        where:
        A            | B            || expectedOut
        [0]          | [0]          || 0
        [0]          | [1]          || -1
        [1, 2]       | [2, 1]       || 1
        [4, 0, 1, 4] | [3, 1, 2, 3] || 3

    }
}

