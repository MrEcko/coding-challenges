package world.coding.challenges.leetcode.easy;

import spock.lang.Shared;
import spock.lang.Specification;

class DeleteColumnsToMakeSortedTest extends Specification {
    @Shared
    private static DeleteColumnsToMakeSorted solution = new DeleteColumnsToMakeSorted()

    def "DeleteColumnsToMakeSorted"() {
        expect:
        solution.minDeletionSize(input as String[]) == expectedOut

        where:
        input                 || expectedOut
        ["cba", "daf", "ghi"] || 1
        ["a", "b"]            || 0
        ["zyx", "wvu", "tsr"] || 3
    }
}

