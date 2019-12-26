package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
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
