package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class DecompressRLEListTest extends Specification {
    @Shared
    private static DecompressRLEList DecompressRLEList = new DecompressRLEList()

    def "DecompressRLEList"() {
        expect:
        DecompressRLEList.decompressRLElist(input as int[]) == expectedOut as int[]

        where:
        input        || expectedOut
        [1, 2, 3, 4] || [2, 4, 4, 4]
    }
}

