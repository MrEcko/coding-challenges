package world.coding.challenges.leetcode.challenge30days

import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class PerformStringShiftsTest extends Specification {
    @Shared
    private static PerformStringShifts solution = new PerformStringShifts()

    def "PerformStringShifts"() {
        expect:
        solution.stringShift(input, shifts as int[][]) == expectedOut

        where:
        input   | shifts                                   || expectedOut
//        "abc"     | [[0, 0]]                                 || "abc"
//        "abc"     | [[0, 1]]                                 || "bca"
//        "abc"     | [[0, 2]]                                 || "cab"
//        "abc"     | [[0, 3]]                                 || "abc"
//        "abc"     | [[1, 0]]                                 || "abc"
//        "abc"     | [[1, 1]]                                 || "cab"
//        "abc"     | [[1, 2]]                                 || "bca"
//        "abc"     | [[1, 3]]                                 || "abc"
//        "abc"     | [[0, 1], [1, 2]]                         || "cab"
//        "abcdefg" | [[1, 1], [1, 1], [0, 2], [1, 3]]         || "efgabcd"
        "mecsk" | [[1, 4], [0, 5], [0, 4], [1, 1], [1, 5]] || "kmecs"

//        mecsk
//        [1, 4]
//        ecskm
//
//        [0, 5]
//        meskm
//
//        [0, 4]
//
//        [1, 1]
//
//        [1, 5]

    }

    def "readInOrder"() {
        expect:
        solution.readCircularlyFromIndex(input.toCharArray(), start) == expectedOutput

        where:
        input     | start || expectedOutput
        "abcdefg" | 0     || "abcdefg"
        "abcdefg" | 4     || "efgabcd"
        "abcdefg" | 6     || "gabcdef"
        "abcdefg" | 7     || "abcdefg"
    }

    def "leftShift"() {

        expect:
        solution.leftShift(start, length, amount) == expectedOutput

        where:
        start | length | amount || expectedOutput
        0     | 3      | 0      || 0
        0     | 3      | 1      || 1
        0     | 3      | 2      || 2
        0     | 3      | 3      || 0
        0     | 3      | 4      || 1
        0     | 3      | 5      || 2
        2     | 3      | 1      || 0
        0     | 7      | 2      || 2
    }


    @Unroll
    @IgnoreRest
    def "rightShift"() {
        expect:
        solution.rightShift(start, length, amount) == expectedOutput

        where:
        start | length | amount || expectedOutput
        1     | 7      | 3      || 5
        0     | 3      | 0      || 0
        0     | 3      | 1      || 2
        0     | 3      | 2      || 1
        0     | 3      | 3      || 0
        0     | 3      | 4      || 2
        0     | 3      | 5      || 1
        2     | 3      | 1      || 1
        4     | 5      | 5      || 4
    }

}

