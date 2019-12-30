package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class FishTest extends Specification {
    @Shared
    private static Fish fish = new Fish()

    def "FishChallenge"() {
        expect:
        fish.solution([4, 3, 2, 1, 5] as int[], [0, 1, 0, 0, 0] as int[]) == 2
    }
}

