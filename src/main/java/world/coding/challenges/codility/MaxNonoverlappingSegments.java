package world.coding.challenges.codility;

public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int output = 0;
        if (A.length == 0) return output;

        int previousEnd = B[0];
        output++;
        for (int i=1; i<A.length; i++){
            if (A[i]>previousEnd){
                previousEnd = B[i];
                output++;
            }
        }
        return output;
    }
}
