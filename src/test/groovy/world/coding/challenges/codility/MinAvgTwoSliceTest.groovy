package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class MinAvgTwoSliceTest extends Specification {

    @Shared
    private MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

    def "MinAvgTwoSlice"() {
        given:
        def input = [4,2,2,5,1,5,8] as int[]
        def expectedOutput = 1

        expect:
        minAvgTwoSlice.solution(input) == expectedOutput
    }
}
