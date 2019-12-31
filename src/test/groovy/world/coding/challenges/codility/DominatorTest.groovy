package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class DominatorTest extends Specification {
    @Shared
    private static Dominator dominator = new Dominator()

    def "Dominator"() {
        expect:
        dominator.solution(input as int[]) == expectedOut

        where:
        input                     || expectedOut
        [3, 4, 3, 2, 3, -1, 3, 3] || 0
        [1]                       || 0
        [1, 2]                    || -1
        [1, 2, 2]                 || 1
        [2, 2, 1]                 || 0
        [1, 2, 3]                 || -1

    }
}

