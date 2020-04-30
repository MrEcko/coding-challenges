package world.coding.challenges.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // running sum
    public int subarraySum(int[] nums, int k) {

        int sum = 0, output = 0;
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        prefixSumCounts.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (prefixSumCounts.containsKey(sum - k)) {
                output += prefixSumCounts.get(sum - k);
            }
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum, 0) + 1);
        }

        return output;

    }

}
