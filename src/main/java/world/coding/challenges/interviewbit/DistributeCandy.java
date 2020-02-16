package world.coding.challenges.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/distribute-candy/
 */
public class DistributeCandy {

    public int candyEditorial(ArrayList<Integer> A) {
        int n = A.size();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n - 1; i++) {
            if (A.get(i + 1) > A.get(i))
                candies[i + 1] = candies[i] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            //increasing right to left
            if (A.get(i - 1) > A.get(i) && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }
        return Arrays.stream(candies).sum();
    }
}
