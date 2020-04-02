package world.coding.challenges.leetcode.challenge30days;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3283/
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * XOR approach works because it's max of 2 duplicates
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int output = 0;
        for (int num : nums) output ^= num;
        return output;
    }

}
