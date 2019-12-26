package world.coding.challenges.codility;

import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
 */
public class FrogRiverOne {

    /**
     * @param X an integer (position 0) and wants to get to the opposite bank (position X+1).
     * @param A array A consisting of N integers representing the falling leaves.
     *         A[K] represents the position where one leaf falls at time K, measured in seconds.
     * @return earliest time when the frog can jump to the other side of the river.
     */
    public int solution(int X, int[] A){
        int output = -1;

        Set<Integer> positions = new HashSet<>();
        for (int i=1; i<=X; i++){
            positions.add(i);
        }
        for (int i=0; i < A.length; i++){
            if (positions.contains(A[i])){
                positions.remove(A[i]);
            }
            if (positions.size() == 0){
                output = i;
                break;
            }
        }

        return output;
    }
}
