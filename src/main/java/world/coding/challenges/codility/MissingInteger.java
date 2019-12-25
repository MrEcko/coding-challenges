package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 *
 * Given A = [1, 2, 3], the function should return 4.
 *
 * Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MissingInteger {

    /**
     * @param A  array A
     * @return 1 if array {@param A} is a permutation and 0 if it is not.
     * A permutation is a sequence containing each element from 1 to N once, and only once.
     * TODO see 100% solutions https://pbedn.github.io/post/2017-codility-demo-test/
     */
    public int solution(int[] A) {
        int output = 0;
        int N = A.length;
        int[] countOccurences = new int[N+1];

        for (int i=0; i<N; i++){
            if (A[i] > 0 && A[i] <= N){
                countOccurences[A[i]]++;
            }
        }
        for (int i=1; i<=N; i++){
            if (countOccurences[i] == 0){
                output = i;
                break;
            }
        }
        if (output == 0){
            output = N+1;
        }
        return output;
    }
}
