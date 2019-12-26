package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class GenomicRangeQueryTest extends Specification {

    @Shared
    private GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

    def "GenomicRange"() {
        given:
        def dnaSequence = "CAGCCTA";
        def P = [2,5,0] as int[]
        def Q = [4,5,6] as int[]
        def expectedOutput = [2,4,1]

        expect:
        genomicRangeQuery.solution(dnaSequence, P, Q) == expectedOutput
    }
}
