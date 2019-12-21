package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 */
public class PermMissingElem {

    /**
     * @param A array consisting of N distinct integers in the range [1..(N + 1)] (one element is missing)
     *          N is an integer within the range [0..100,000];
     * @return  returns the value of the missing element.
     */
    public int solution(int[] A){
        int output = 0;
        Set<Integer> completeDataset = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++){
            completeDataset.add(i);
        }
        for (int i = 0; i < A.length; i++){
            if (completeDataset.contains(A[i])){
                completeDataset.remove(A[i]);
            }
        }
        //assumption is only 1 is missing, so returning the last one found
        if (completeDataset.size() > 0){
            output = completeDataset.iterator().next();
        }
        return output;
    }
}
