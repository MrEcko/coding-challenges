package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class TieRopesTest extends Specification {
    @Shared
    private static TieRopes TieRopes = new TieRopes()

    def "TieRopes"() {
        expect:
        TieRopes.solution(k, input as int[]) == expectedOut

        where:
        k | input                 || expectedOut
        4 | [1, 2, 3, 4, 1, 1, 3] || 3
    }
}

