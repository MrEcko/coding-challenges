package world.coding.challenges.codility;

import java.util.*;
/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/
 */
public class Nesting {
    public int solution(String S) {
        int n = S.length();
        int output = 0;
        if (n==0){
            output = 1;
        } else if(n % 2 == 0){
            Stack<Character> openNestings = new Stack<>();
            for (int i=0; i<n; i++){
                char c = S.charAt(i);
                if (c == '('){
                    openNestings.push(c);
                    // System.out.println(openNestings);
                } else{
                    if (openNestings.isEmpty()){
                        // System.out.println("Empty nestings on ) break");
                        return 0;
                    } else {
                        // System.out.println("Found " + c + " popping");
                        openNestings.pop();
                        // System.out.println(openNestings);
                    }
                }
            }
            output = (openNestings.size() == 0) ? 1  : 0;
        }
        return output;
    }
}
