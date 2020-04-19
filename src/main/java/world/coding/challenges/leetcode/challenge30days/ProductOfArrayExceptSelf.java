package world.coding.challenges.leetcode.challenge30days;

/**
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = output[i] * left;
            left = left * nums[i];
        }
        return output;
    }
}
