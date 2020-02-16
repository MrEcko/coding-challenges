package world.coding.challenges.interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class MaxSumContiguousSubarray {
    int[] prefixSum(List<Integer> input) {
        int[] prefixSum = new int[input.size() + 1];
        for (int i = 1; i < input.size() + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + input.get(i - 1);
        }
        return prefixSum;
    }

    int countTotal(int[] prefixSum, int x, int y) {
        return prefixSum[y + 1] - prefixSum[x];
    }

    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int output = Integer.MIN_VALUE;
        int[] prefixSum = prefixSum(A);
        for (int w=0; w<n; w++){
            for (int i=0; i<n-w; i++){
                int windowSum = countTotal(prefixSum, i, i+w);
                output = Math.max(output, windowSum);
            }
        }
        return output;
    }
}
