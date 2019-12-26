package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
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
