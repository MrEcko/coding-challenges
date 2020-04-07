package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class MoveZeroesTest extends Specification {
    @Shared
    private static MoveZeroes solution = new MoveZeroes()

    def "MoveZeroes"() {
        when:
        def output = input.clone()
        solution.moveZeroes(output)

        then:
        expectedOut == output

        where:
        input                     || expectedOut
        [0, 1, 0, 3, 12] as int[] || [1, 3, 12, 0, 0] as int[]
    }
}

