package world.coding.challenges.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/decompress-run-length-encoded-list/
 */
public class DecompressRLEList {

    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;

        List<Integer> output = new ArrayList<>();
        for (int i=0; i<n-1; i=i+2){
            int val = nums[i+1];
            for (int k=0; k<nums[i]; k++){
                output.add(val);
            }
        }

        return output.stream().mapToInt(i->i).toArray();

    }
}
