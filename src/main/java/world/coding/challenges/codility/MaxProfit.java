package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/
 */
public class MaxProfit {
    public int solution(int[] A) {
        int n = A.length;
        int output = 0;
        if (n > 1) {
            // min buying price on day i is min(0..i-1)
            int[] minBought = new int[n];
            int currentMin = Integer.MAX_VALUE;
            minBought[0] = currentMin;
            for (int i = 1; i < n; i++) {
                currentMin = Math.min(A[i - 1], currentMin);
                minBought[i] = currentMin;
            }
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                maxProfit = Math.max(maxProfit, A[i] - minBought[i]);
            }
            output = maxProfit;
        }
        return output;
    }
}
