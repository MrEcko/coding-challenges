package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class SearchInRotatedSortedArrayTest extends Specification {
    @Shared
    private static SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray()

    def "SearchInRotatedSortedArray"() {
        expect:
        solution.search(input as int[], target) == expectedOut

        where:
        input                 | target || expectedOut
        [4, 5, 6, 7, 0, 1, 2] | 0      || 4
        [4, 5, 6, 7, 0, 1, 2] | 3      || -1
    }
}

