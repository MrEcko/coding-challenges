package world.coding.challenges.leetcode.challenge30days;

import spock.lang.Shared;
import spock.lang.Specification;

class NumberOfIslandsTest extends Specification {
    @Shared
    private static NumberOfIslands solution = new NumberOfIslands()

    def "NumberOfIslands"() {
        given:
        char[][] grid = new char[input.size()];
        for (int i = 0; i < input.size(); i++) {
            grid[i] = input.get(i).toCharArray();
        }
        expect:
        solution.numIslands(grid) == expectedOut

        where:
        input     || expectedOut
        []        || 0
        [""]      || 0
        ["11110",
         "11010",
         "11000",
         "00000"] || 1
        ["11000",
         "11000",
         "00100",
         "00011"] || 3
    }
}

