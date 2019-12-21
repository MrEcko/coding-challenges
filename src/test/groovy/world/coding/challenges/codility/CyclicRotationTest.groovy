package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class CyclicRotationTest extends Specification{

    @Shared private CyclicRotation cyclicRotation = new CyclicRotation();

    def "CyclicRotation"(){
        expect:
        int[] A = [3, 8, 9, 7, 6]
        int K = 3
        cyclicRotation.solution(A,K) == [9, 7, 6, 3, 8] as int[]

    }
}
