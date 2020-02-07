package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class MaxNonoverlappingSegmentsTest extends Specification {
    @Shared
    private static MaxNonoverlappingSegments MaxNonoverlappingSegments = new MaxNonoverlappingSegments()

    def "MaxNonoverlappingSegments"() {
        expect:
        MaxNonoverlappingSegments.solution(starts as int[], ends as int[]) == expectedOut

        where:
        starts          | ends             || expectedOut
        [1, 3, 7, 9, 9] | [5, 6, 8, 9, 10] || 3
    }
}

