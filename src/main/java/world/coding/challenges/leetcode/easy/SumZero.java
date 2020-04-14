package world.coding.challenges.leetcode.easy;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/submissions/
 */
public class SumZero {
    public int[] sumZero(int n) {
        int[] output = new int[n];
        if (n > 0) {
            int idx = 0;
            if (n % 2 != 0) {
                idx = 1;
            }
            for (int i = 1; i <= n / 2; i++) {
                output[idx++] = i + 1;
                output[idx++] = -1 * (i + 1);
            }
        }
        return output;
    }
}
