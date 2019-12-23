package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class FrogRiverOneTest extends Specification {

    @Shared
    private FrogRiverOne frogRiverOne = new FrogRiverOne();

    @Unroll
    def "PermMissingElem"() {
        expect:
        frogRiverOne.solution(X, input as int[]) == expectedOutput

        where:
        input                    | X || expectedOutput
        [1, 3, 1, 4, 2, 3, 5, 4] | 5 || 6
    }
}
