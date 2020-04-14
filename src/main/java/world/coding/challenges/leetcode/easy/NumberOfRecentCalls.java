package world.coding.challenges.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-recent-calls/
 */
public class NumberOfRecentCalls {
    Queue<Integer> queue;

    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        int start = t - 3000;
        while(queue.size()>0 && queue.peek() < start){
            queue.poll();
        }
        return queue.size();
    }
}
