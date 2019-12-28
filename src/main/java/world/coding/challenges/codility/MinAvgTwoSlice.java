package world.coding.challenges.codility;


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

        //total of a slice [x,y] from prefixSum is P[Y+1]-P[X]
        int minStart = -1;
        float minAvg = (float)Integer.MAX_VALUE;
        for (int i = 0; i < A.length-1; i++){
            //can there be slices with more than 2 els that have lower average?
            // yes with 3 - "proof" https://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
            int sum = A[i] + A[i+1];
            float avg = (float)sum / (2);
            if (i < A.length-2){
                int sumOfThree = sum + A[i+2];
                avg = Math.min(avg, (float)sumOfThree/3);
            }
            if (avg<minAvg){
                minAvg = avg;
                minStart = i;
            }

        }
        output = minStart;
        return output;
    }
}
