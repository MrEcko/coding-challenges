package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class BracketsTest extends Specification {
    @Shared
    private static Brackets Brackets = new Brackets()

    def "Brackets"() {
        expect:
        Brackets.solution(input) == expectedOut

        where:
        input      || expectedOut
        "{[()()]}" || 1
        "([)()]"   || 0
    }
}

