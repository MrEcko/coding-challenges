package world.coding.challenges.codility;

import spock.lang.Shared;
import spock.lang.Specification;

class NestingTest extends Specification {
    @Shared
    private static Nesting nesting = new Nesting()

    def "Nesting"() {
        expect:
        nesting.solution(input) == expectedOut

        where:
        input        || expectedOut
        "(()(())())" || 1
        "())"        || 0
        "("          || 0
        ")"          || 0
        ")("         || 0
        ")()()"      || 0
        "()()()(())" || 1
        ""           || 1
    }
}

