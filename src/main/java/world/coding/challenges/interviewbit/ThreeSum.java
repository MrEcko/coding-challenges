package world.coding.challenges.interviewbit;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/3-sum/
 * <p>
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers.
 * <p>
 * Assume that there will only be one solution
 * <p>
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class ThreeSum {

    public int threeSumClosest(ArrayList<Integer> input, int target) {
        int n = input.size();
        if (n <= 3) {
            return input.stream().reduce(0, Integer::sum);
        }

        Collections.sort(input);
        long minDiff = Integer.MAX_VALUE;
        long sum, output = target;
        for (int i = 0; i < n - 2; i++) {
            int lower = i + 1;
            int upper = n - 1;
            while (lower < upper) {
                sum = input.get(i) + input.get(lower) + input.get(upper);
                if (Math.abs(target - sum) < minDiff) {
                    minDiff = Math.abs(target - sum);
                    output = sum;
                }
                if (sum < target) lower++;
                else upper--;
            }
        }
        return (int) output;
    }
}
