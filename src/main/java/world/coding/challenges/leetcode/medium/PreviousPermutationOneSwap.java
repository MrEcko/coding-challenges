package world.coding.challenges.leetcode.medium;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/previous-permutation-with-one-swap/
 */
public class PreviousPermutationOneSwap {
    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        if (n==0) return A;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        //least significant first to get as high as possible to A
        //find first A[i] > A[j], A[j] has max out of (i..n)
        for(int i = n-1; i >= 0; i--) {
            Integer closestLowerBound = map.lowerKey(A[i]);
            map.put(A[i], i);
            if(closestLowerBound == null) {
                continue;
            }

            Integer j = map.get(closestLowerBound);
            if(j != null) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
                break;
            }
        }
        return A;
    }
}
