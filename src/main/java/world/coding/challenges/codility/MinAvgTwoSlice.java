package world.coding.challenges.codility;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/
 */
public class MinAvgTwoSlice {

    /**
     * @param A array consisting of N integers. N in [2..100,000]
     *      A[i] in [-10,000..10,000]
     * @return the starting position of a slice with minimal average
     */
    public int solution(int[] A) {
        int output = 0;

        int[] prefixSum = new int[A.length+1];
        for (int i=1; i<A.length+1; i++){
            prefixSum[i] = prefixSum[i-1] + A[i-1];
        }
        // System.out.println(Arrays.toString(prefixSum));

        //total of a slice [x,y] from prefixSum is P[Y+1]-P[X]
        int minStart = -1;
        float minAvg = (float)Integer.MAX_VALUE;
        for (int i = 0; i < A.length-1; i++){
            //can there be slices with more than 2 els that have lower average?
            // yes because of negative numbers?
            for (int j = i+1; j < A.length; j++){
                int sum = prefixSum[j+1] - prefixSum[i];
                float avg = (float)sum / (j+1-i);
                //todo - make it more efficient so that we can guaruantee first hit is the min
                if (avg<minAvg){
                    minAvg = avg;
                    minStart = i;
                }
                // System.out.println("sum["+i+","+j+"] = "+sum+" avg= "+avg);
            }
        }
        output = minStart;
        return output;
    }
}
