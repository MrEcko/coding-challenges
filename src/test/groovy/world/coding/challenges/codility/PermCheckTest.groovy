package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PermCheckTest extends Specification {

    @Shared
    private PermCheck permCheck = new PermCheck();

    @Unroll
    def "PermCheck"() {
        expect:
        permCheck.solution(input as int[]) == expectedOutput


        where:
        input        || expectedOutput
        [1]          || 1
        [0]          || 0
        [2]          || 0
        [4, 3, 1]    || 0
        [4, 1, 3, 2] || 1
    }
}
