package world.coding.challenges.interviewbit;

import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    private int area(int s, int e, int w) {
        return Math.min(s, e) * w;
    }

    public int maxArea(ArrayList<Integer> A) {
        int n = A.size();
        if (n==1) return 0;
        int start = 0, end = n - 1;
        int area = -1;
        while (start < end) {
            area = Math.max(area(A.get(start), A.get(end), end-start), area);
            if (A.get(start) <= A.get(end)) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }
}
