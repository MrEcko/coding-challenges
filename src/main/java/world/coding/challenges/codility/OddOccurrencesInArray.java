package world.coding.challenges.codility;

import java.util.Set;
import java.util.HashSet;
/**
 * https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray {

    public int solution(int[] A){
        int output = 0;
        Set<Integer> unpairedElements = new HashSet<>();
        for (int i=0; i < A.length; i++){
            if (unpairedElements.contains(A[i])){
                unpairedElements.remove(A[i]);
            } else{
                unpairedElements.add(A[i]);
            }
        }
        if (unpairedElements.size()>0){
            //grab first element, since assumption is there will be only 1 in the input
            output = unpairedElements.iterator().next();
        }
        return output;
    }
}
