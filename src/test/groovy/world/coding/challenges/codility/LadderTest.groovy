package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class LadderTest extends Specification {
    @Shared
    private static Ladder Ladder = new Ladder()

    def "Ladder"() {
        Ladder.solution(A as int[], B as int[]) == [expectedOut]

        where:
        A               | B               || expectedOut
        [4, 4, 5, 5, 1] | [3, 2, 4, 3, 1] || [5, 1, 8, 0, 1]
    }
}

