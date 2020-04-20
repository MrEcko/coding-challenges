package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification
import spock.lang.Unroll;

class ValidParenthesisStringTest extends Specification {
    @Shared
    private static ValidParenthesisString solution = new ValidParenthesisString()

    @Unroll
    def "ValidParenthesisString"() {
        expect:
        solution.checkValidString(input) == expectedOut

        where:
        input                                                || expectedOut
        ""                                                   || true
        "*"                                                  || true
        "("                                                  || false
        ")"                                                  || false
        "(("                                                 || false
        "))"                                                 || false
        "()"                                                 || true
        "(*()"                                               || true
        "(*)"                                                || true
        "(*))"                                               || true
        "((*()"                                              || false
        "((*)))"                                             || true
        "((**))"                                             || true
        "((***))"                                            || true
        "((****))"                                           || true
        "***((("                                             || false
        "**(*(("                                             || false
        "*(*(*("                                             || false
        "(*(*(*"                                             || true
        "(())((())()()(*)(*()(())())())()()((()())((()))(*"  || false
        "((()))()(())(*()()())**(())()()()()((*()*))((*()*)" || true
        "(**((**))((**)"                                     || true
//        "((*()*)"
//        "((*()"


//        (*   )**((*()*))((*()    *)
//
//        (*   )**((**))((*    *)

//        (**((**))((**)



    }
}

