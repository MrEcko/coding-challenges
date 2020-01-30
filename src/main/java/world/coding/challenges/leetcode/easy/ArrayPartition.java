package world.coding.challenges.leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int output = 0;
        for (int i=0; i<nums.length-1; i=i+2){
            output += nums[i];
        }
        return output;
    }

}
