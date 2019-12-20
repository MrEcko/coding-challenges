package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class BinaryGapTest extends Specification{

    @Shared private BinaryGap binaryGap = new BinaryGap();

    @Unroll
    def "longest binary gap for the decimal no. #input / binary #inputInBinary is #expectedOutput"() {
        expect:
        binaryGap.solution(input) == expectedOutput

        where:
        input      | inputInBinary                      || expectedOutput
        -10        | Integer.toBinaryString(-10)        || 0
        0          | Integer.toBinaryString(0)          || 0
        9          | Integer.toBinaryString(9)          || 2
        10         | Integer.toBinaryString(10)         || 1
        15         | Integer.toBinaryString(15)         || 0
        20         | Integer.toBinaryString(20)         || 1
        32         | Integer.toBinaryString(32)         || 0
        99         | Integer.toBinaryString(99)         || 3
        257        | Integer.toBinaryString(257)        || 7
        529        | Integer.toBinaryString(529)        || 4
        1029       | Integer.toBinaryString(1029)       || 7
        1041       | Integer.toBinaryString(1041)       || 5
        4000       | Integer.toBinaryString(4000)       || 1
        2147483647 | Integer.toBinaryString(2147483647) || 0
    }
}
