package world.coding.challenges.interviewbit;

import java.util.List;

/**
 * https://www.interviewbit.com/problems/gas-station/
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int n = A.size();
        int start = 0, end = 0, total = 0, gas = 0;
        while (end < n) {
            int consumption = A.get(end) - B.get(end);
            gas += consumption;
            total += consumption;
            if (gas<0){
                start = end + 1;
                end++;
                gas = 0;
            }
            else end++;
        }
        if (total < 0) return -1;
        else return start;
    }
}
