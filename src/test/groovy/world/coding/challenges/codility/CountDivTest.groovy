package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class CountDivTest extends Specification {

    @Shared
    private CountDiv countDiv = new CountDiv();

    @Unroll
    def "CountDiv"() {
        expect:
        countDiv.solution(A, B, K) == expectedOutput

        where:
        A   | B                 | K                 || expectedOutput
        6   | 11                | 2                 || 3
        11  | 345               | 17                || 20
        0   | 1                 | 11                || 1
        10  | 10                | 5                 || 1
        10  | 10                | 7                 || 0
        10  | 10                | 20                || 0
        100 | 123000000         | 2                 || 61499951
        101 | 123000000         | 10000             || 12300
        0   | Integer.MAX_VALUE | 1                 || Integer.MAX_VALUE
        0   | Integer.MAX_VALUE | Integer.MAX_VALUE || 1
    }
}
