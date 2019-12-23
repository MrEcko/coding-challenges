package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class TapeEquilibriumTest extends Specification{

    @Shared private TapeEquilibrium tapeEquilibrium = new TapeEquilibrium()

    def "TapeEquilibrium"(){
        given:
        def input = [3, 1, 2, 4, 3] as int[]

        expect:
        tapeEquilibrium.solution(input) == 1
    }
}
