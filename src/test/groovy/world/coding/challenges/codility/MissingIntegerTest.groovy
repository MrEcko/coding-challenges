package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class MissingIntegerTest extends Specification {

    @Shared
    private MissingInteger missingInteger = new MissingInteger()

    def "MissingInteger"() {

        expect:
        missingInteger.solution(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [1, 3, 6, 4, 1, 2] || 5
        [1, 2, 3]          || 4
        [-1, -3]           || 1
    }
}
