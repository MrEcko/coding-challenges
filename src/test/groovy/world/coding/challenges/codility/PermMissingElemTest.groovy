package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PermMissingElemTest extends Specification {

    @Shared
    private PermMissingElem permMissingElem = new PermMissingElem();

    @Unroll
    def "PermMissingElem"() {
        expect:
        permMissingElem.solution(input as int[]) == expectedOutput


        where:
        input                 || expectedOutput
        []                    || 1
        [2, 3, 1, 5]          || 4
        [1]                   || 2
        [2]                   || 1
        [1, 2]                || 3
        [1, 2, 3, 4, 5]       || 6
        [1..100000].flatten() || 100001
    }
}
