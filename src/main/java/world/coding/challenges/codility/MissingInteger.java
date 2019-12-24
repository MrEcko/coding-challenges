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
     */
    public int solution(int[] A) {
        int output = 0;
        int max = IntStream.of(A).boxed().max(Integer::compareTo).orElse(0);
        if (max<=0){
            output = 1;
        } else{
            //if there is any gap, pick it
            Set<Integer> input = IntStream.of(A).boxed().collect(Collectors.toSet());
            for (int i = 1; i <= max; i++){
                if (!input.contains(i)){
                    output = i;
                    break;
                }
            }

            //if there is was no gap, next min is max+1
            if (output == 0){
                output = ++max;
            }

        }
        return output;
    }
}
