package world.coding.challenges.leetcode.challenge30days;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            maxHeap.add(stone);
        }
        while (!maxHeap.isEmpty()){
            Integer y = maxHeap.remove();
            if (maxHeap.isEmpty()) return y;
            Integer x = maxHeap.remove();
            if (x<y){
                maxHeap.add(y-x);
            }
        }
        return 0;

    }
}
