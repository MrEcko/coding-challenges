package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification

import java.lang.reflect.Array;

class SumZeroTest extends Specification {
    @Shared
    private static SumZero solution = new SumZero()

    def "SumZero"() {
        when:
        def output = solution.sumZero(input)

        then:
        output.length == expectedSize
        output.sum() == 0
        (output as ArrayList<Integer>).unique() == output as ArrayList<Integer>

        where:
        input || expectedSize
        5     || 5
        10    || 10
    }
}

