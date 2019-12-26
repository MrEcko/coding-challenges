package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class FrogJmpTest extends Specification{
    @Shared private FrogJmp frogJmp = new FrogJmp()

    def "FrogJmp"(){
        expect:
        frogJmp.solution(X,Y,D) == expectedOutput

        where:
        X  | Y  | D  || expectedOutput
        10 | 85 | 30 || 3
        1  | 5  | 2  || 2
    }
}
