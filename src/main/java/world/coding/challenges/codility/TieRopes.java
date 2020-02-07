package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/
 */
public class TieRopes {
    public int solution(int K, int[] A) {
        int output = 0;
        int sum = 0;
        for (int ropeLength : A) {
            if (sum < K) {
                sum += ropeLength;
            } else {
                output++;
                sum = ropeLength;
            }
            if (sum >= K) {
                output++;
                sum = 0;
            }
        }
        return output;
    }
}
