package world.coding.challenges.codility;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/8-leader/dominator/
 */
public class Dominator {
    public int solution(int[] A) {
        int output = -1;
        int n = A.length;
        if (n > 0) {
            int[] input = A.clone();
            Arrays.sort(input);
            float halfSize = (float) n / 2;

            int candidateDominatorIndex = -1;
            int candidateDominator = input[(int) halfSize];
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (input[i] == candidateDominator) {
                    count++;
                    if (count > halfSize) {
                        candidateDominatorIndex = i;
                        break;
                    }
                }
            }
            if (candidateDominatorIndex != -1) {
                for (int i = 0; i < n; i++) {
                    if (A[i] == candidateDominator) {
                        output = i;
                        break;
                    }
                }
            }


        }
        return output;
    }
}
