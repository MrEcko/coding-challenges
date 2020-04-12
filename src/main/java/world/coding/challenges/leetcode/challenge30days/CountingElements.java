package world.coding.challenges.leetcode.challenge30days;

import java.util.HashMap;
import java.util.Map;

/**
 * Linear space complexity.
 * For constant space and n Log n time sorting & counting can work
 */
public class CountingElements {
    public int countElements(int[] arr) {
        int n = arr.length;
        if (n < 1) return 0;
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int x : arr) {
            occurrences.putIfAbsent(x, 1);
        }
        int output = 0;
        for (int x : arr){
            Integer increment = occurrences.get(x + 1);
            if (increment != null) output+=increment;
        }
        return output;
    }
}
