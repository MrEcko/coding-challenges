package world.coding.challenges.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/height-checker/
 */
public class HeightChecker {
    public int heightChecker(int[] heights) {
        int output = 0;
        int[] sortedHeights = heights.clone();
        Arrays.sort(sortedHeights);
        for (int i=0; i<heights.length; i++){
            if (heights[i] != sortedHeights[i]) output++;
        }
        return output;
    }
}
