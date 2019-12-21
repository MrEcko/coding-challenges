package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class OddOccurrencesInArrayTest extends Specification{

    @Shared private oddOccurrencesInArray = new OddOccurrencesInArray()
    def "OddOccurrencesInArray"(){
        given:
        int[] inputArray = [9,3,9,3,9,7,9]

        expect:
        oddOccurrencesInArray.solution(inputArray) == 7
    }
}
