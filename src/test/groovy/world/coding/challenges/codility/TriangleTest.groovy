package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class TriangleTest extends Specification {
    @Shared
    private static Triangle Triangle = new Triangle()

    def "Triangle"() {
        expect:
        Triangle.solution(input as int[]) == expectedOut

        where:
        input                || expectedOut
        [10, 2, 5, 1, 8, 20] || 1
        [10, 50, 5, 1]       || 0
    }
}

