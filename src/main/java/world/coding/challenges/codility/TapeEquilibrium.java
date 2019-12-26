package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium {

    public int solution(int[] A) {
        int output = 0;

        if (A.length > 1) {
            int leftSum = A[0];
            int rightSum = 0;
            for (int i=1; i < A.length; i++){ // alternative IntStream.of(A).sum()
                rightSum+= A[i];
            }
            output = Math.abs(leftSum-rightSum);

            for (int P = 2; P < A.length; P++){
                leftSum+= A[P-1];
                rightSum-= A[P-1];
                if (Math.abs(leftSum-rightSum) < output){
                    output = Math.abs(leftSum-rightSum);
                }
            }
        }

        return output;
    }
}
