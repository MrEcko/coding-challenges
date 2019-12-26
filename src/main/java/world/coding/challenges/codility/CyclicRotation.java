package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation {

    /**
     * @param A array consisting of integers
     * @param K rotations to the right
     * @return the array A rotated K times to the right
     */
    public int[] solution(int[] A, int K){
        int[] output = A;
        if (A.length>0){
            for (int i=0; i<K;i++){
                output = rightShift(output);
            }
        }
        return output;
    }

    private int[] rightShift(int A[]){
        int[] output = new int[A.length];
        output[0] = A[A.length-1];
        for (int i=1; i<A.length; i++){
            output[i] = A[i-1];
        }
        return output;
    }
}
