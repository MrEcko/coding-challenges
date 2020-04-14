package world.coding.challenges.leetcode.challenge30days;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < n) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                    j++;
                }
                if (j == n) break;
            }
        }

    }
}
