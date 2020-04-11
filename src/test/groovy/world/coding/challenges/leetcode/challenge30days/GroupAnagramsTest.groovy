package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class GroupAnagramsTest extends Specification {
    @Shared
    private static GroupAnagrams solution = new GroupAnagrams()

    def "GroupAnagrams"() {

        expect:
        solution.groupAnagrams(input as String[]) == expectedOut

        where:
        input                                      || expectedOut
        ["eat", "tea", "tan", "ate", "nat", "bat"] || [["eat", "tea", "ate"], ["bat"], ["tan", "nat"]]
    }
}

