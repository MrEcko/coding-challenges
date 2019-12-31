package world.coding.challenges.codility;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/
 *
 *  [8, 8, 5, 7, 9, 8, 7, 4, 8]
 *  => 7
 *
 * [2,1,4,4,3,2,3,3]
 *    **
 *    *** **
 *  * ******
 *  *********
 *  => 6
 *
 */
public class StoneWall {
    public int solution(int[] H) {
        int output = 0;
        int n = H.length;
        if (n == 1) {
            return 1;
        }

        Stack<Integer> blocks = new Stack<>();
        blocks.add(H[0]);
        int previousHeight = H[0];
        for (int i = 1; i < n; i++) {
            int currentHeight = H[i];
            //blocks are only created when height changes
            //increasing is simple - adds a new block
            if (currentHeight > previousHeight) {
                previousHeight = currentHeight;
                blocks.push(currentHeight);
            //decreasing needs to close all of the taller blocks
            } else if (currentHeight < previousHeight) {
                while (!blocks.isEmpty() && blocks.peek() > currentHeight) {
                    blocks.pop();
                    output++;
                }
                if (blocks.isEmpty() || blocks.peek() != currentHeight) {
                    blocks.add(currentHeight);
                }
                previousHeight = currentHeight;
            }
        }
        output += blocks.size();
        return output;
    }

}
