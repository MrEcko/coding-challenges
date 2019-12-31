package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class StoneWallTest extends Specification {
    @Shared
    private static StoneWall stoneWall = new StoneWall()

    def "StoneWall"() {
        expect:
        stoneWall.solution(input as int[]) == expectedOut

        where:
        input                       || expectedOut
        [8, 8, 5, 7, 9, 8, 7, 4, 8] || 7
        [2, 1, 4, 4, 3, 2, 3, 3]    || 6
    }
}

