package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
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
