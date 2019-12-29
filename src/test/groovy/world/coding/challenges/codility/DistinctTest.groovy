package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class DistinctTest extends Specification {

    @Shared
    private Distinct distinct = new Distinct()

    def "Distinct"() {
        expect:
        distinct.solution(input as int[]) == expectedOut

        where:
        input              || expectedOut
        [1, 2, 2, 2, 3, 3] || 3
    }
}
