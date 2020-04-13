package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification
import spock.lang.Unroll;

class BackspaceStringCompareTest extends Specification {
    @Shared
    private static BackspaceStringCompare solution = new BackspaceStringCompare()

    @Unroll
    def "BackspaceStringCompare"() {
        expect:
        solution.backspaceCompare(S, T) == expectedOut

        where:
        S          | T           || expectedOut
        "ab#c"     | "ad#c"      || true
        "ab##"     | "c#d#"      || true
        "a##c"     | "#a#c"      || true
        "a#c"      | "b"         || false
        "bxj##tw"  | "bxo#j##tw" || true
        "bxj##tw" || "bxj###tw"  || false
        "isfcow#" || "isfcog#w#" || true
        "bbbextm"  | "bbb#extm"  || false
    }
}

