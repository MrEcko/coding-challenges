package world.coding.challenges.codility

import spock.lang.Shared
import spock.lang.Specification

class PassingCarsTest extends Specification {

    @Shared
    private PassingCars passingCars = new PassingCars()

    def "PassingCars"() {
        expect:
        passingCars.solution(input as int[]) == expectedOut
        where:
        input           || expectedOut
        [0, 1, 0, 1, 1] || 5
    }
}
