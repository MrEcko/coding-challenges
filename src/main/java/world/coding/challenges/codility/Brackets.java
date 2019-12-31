package world.coding.challenges.codility;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 */
public class Brackets {
    public int solution(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return 0;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        return 0;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{')
                        return 0;
                    break;
                default:
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
