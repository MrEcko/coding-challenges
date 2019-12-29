package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        return efficientSolution(A, B, K);
//         return bruteForceSolution(A,B,K);
    }

    public int efficientSolution(int A, int B, int K) {
        int start = A / K;
        int end = B / K;
        int output = end - start ;

        if (A % K == 0){
            output++;
        }
        return output;
    }

    public int bruteForceSolution(int A, int B, int K) {
        int output = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                output++;
            }
        }
        return output;
    }
}
