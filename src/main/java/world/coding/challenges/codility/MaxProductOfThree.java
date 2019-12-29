package world.coding.challenges.codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        // for positive numbers it's largest 3, for negatives it's smallest 2 and the largest
        return Math.max(A[0] * A[1] * A[n-1], A[n-1] * A[n-2] * A[n-3]);
    }
}
