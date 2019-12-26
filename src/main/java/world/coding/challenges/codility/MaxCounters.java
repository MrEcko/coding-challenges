package world.coding.challenges.codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters {

    public int[] solution(int N, int[] A) {
        int[] output = new int[N];
        Arrays.fill(output, 0);
        int max = 0;
        int maxValueToSet = 0;

        //only need to set the max at array level once
        // if an item needs incrementing, it will also get the max before
        for (int X : A) {
            if (X <= N) {
                //only update max as needed for increase
                if (output[X - 1] < maxValueToSet) {
                    output[X - 1] = maxValueToSet;
                }
                output[X - 1]++;
                if (output[X - 1] > max) {
                    max = output[X - 1];
                }
            } else {
                maxValueToSet = max;
            }
        }

        // last max can now be set on those which haven't been incremented afterwards
        for(int i = 0; i < N; i++) {
            if (output[i] < maxValueToSet) {
                output[i] = maxValueToSet;
            }
        }
        return output;
    }
}
