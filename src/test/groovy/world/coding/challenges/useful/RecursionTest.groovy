package world.coding.challenges.useful

import spock.lang.IgnoreRest;
import spock.lang.Shared;
import spock.lang.Specification
import spock.lang.Unroll;

class RecursionTest extends Specification {

    def "Recursion reverse"() {
        expect:
        Recursion.reverse("abc") == "cba"
        Recursion.reverseExplicit("abc") == "cba"
    }

    def "Recursion print array"() {
        given:
        def buffer = new ByteArrayOutputStream()
        System.out = new PrintStream(buffer)
        int[] arr = [1, 2, 3, 4, 5]

        when:
        Recursion.printArrayElements(arr)

        then:
        buffer.toString() == arr.join("\n").toString() + "\n"
    }

    def "Recursion print array explicit stack"() {
        given:
        def buffer = new ByteArrayOutputStream()
        System.out = new PrintStream(buffer)
        int[] arr = [4, 5, 6, 7, 8]

        when:
        Recursion.printArrayElementsExplicit(arr)

        then:
        buffer.toString() == arr.join("\n").toString() + "\n"
    }

    def "Recursion palindrome"() {
        expect:
        Recursion.isStringPalindrome(input) == isPalindrome
        Recursion.isStringPalindromeExplicit(input) == isPalindrome

        where:
        input  || isPalindrome
        "abc"  || false
        "aba"  || true
        "ab"   || false
        "aa"   || true
        "a"    || true
        "abba" || true
    }

    def "Recursion pow"() {
        expect:
        Recursion.pow(a,b) == expectedOutput
        Recursion.powExplicit(a,b) == expectedOutput


        where:
        a | b || expectedOutput
        3 | 2 || 9
        2 | 3 || 8
    }
}

