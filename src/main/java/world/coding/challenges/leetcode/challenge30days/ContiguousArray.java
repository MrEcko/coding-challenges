package world.coding.challenges.leetcode.challenge30days;

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int sum = 0;
        int n = nums.length;
        if (n<2) return sum;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            map.putIfAbsent(sum, i);
        }
        return maxLength;
    }

}
