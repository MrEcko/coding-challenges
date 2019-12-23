package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * A non-empty array A consisting of N integers is given.
 *
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 *
 * For example, array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * is a permutation, but array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * is not a permutation, because value 2 is missing.
 *
 * The goal is to check whether array A is a permutation.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 *
 * For example, given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * the function should return 1.
 *
 * Given array A such that:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 */
public class PermCheck {

    /**
     * @param A  array A
     * @return 1 if array {@param A} is a permutation and 0 if it is not.
     * A permutation is a sequence containing each element from 1 to N once, and only once.
     */
    public int solution(int[] A) {
        int output = 0;

        if (A.length > 0){
            Set<Integer> permutation = new HashSet<>();
            for (int i=1; i<= A.length; i++){
                permutation.add(i);
            }
            for (int i=0; i < A.length; i++){
                if (permutation.contains(A[i])){
                    permutation.remove(A[i]);
                }
            }
            if (permutation.size() == 0){
                output = 1;
            }
        }

        return output;
    }
}
