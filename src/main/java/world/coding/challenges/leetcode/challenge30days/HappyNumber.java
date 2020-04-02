package world.coding.challenges.leetcode.challenge30days;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visitedNumbers = new HashSet<>();
        while (visitedNumbers.add(n)){
            int sum = 0;
            while (n != 0){
                int digit = n % 10;
                sum +=  digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
