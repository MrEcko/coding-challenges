package world.coding.challenges.leetcode.challenge30days;

import java.util.List;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
 */
public class MaximumSubarray {
    int[] prefixSum(int[] input) {
        int[] prefixSum = new int[input.length + 1];
        for (int i = 1; i < input.length + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + input[i - 1];
        }
        return prefixSum;
    }

    int countTotal(int[] prefixSum, int x, int y) {
        return prefixSum[y + 1] - prefixSum[x];
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int output = Integer.MIN_VALUE;
        int[] prefixSum = prefixSum(nums);
        for (int w=0; w<n; w++){
            for (int i=0; i<n-w; i++){
                int windowSum = countTotal(prefixSum, i, i+w);
                output = Math.max(output, windowSum);
            }
        }
        return output;
    }
}
