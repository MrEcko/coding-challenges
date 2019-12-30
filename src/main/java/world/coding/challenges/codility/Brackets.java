package world.coding.challenges.codility;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 */
public class Brackets {
    public int solution(String S) {
        int output = 0;
        int n = S.length();
        if (n > 0 && n % 2 == 0){
            Deque<Character> stackOfOpenings = new ArrayDeque<>();
            boolean allValid = true;
            print("last: "+S.charAt(n-1));
            for (int i=0; i<S.length(); i++){
                char c = S.charAt(i);
                print("the c: " + c);
                if (isOpening(c)){
                    stackOfOpenings.addFirst(c);
                    print("c: " + c + " -> " + stackOfOpenings);
                    allValid = false;
                } else{
                    Character previousC = stackOfOpenings.peekFirst();
                    print("current c: " + c+ " previousC: " + previousC);
                    if (previousC == null || !isCorrectNesting(previousC,c)){
                        allValid = false;
                        break;
                    } else{
                        stackOfOpenings.removeFirst();
                        allValid= true;
                    }
                }
            }
            output = allValid ? 1 : 0;
        }
        return output;
    }

    void print (Object o){
        // System.out.println(o);
    }

    boolean isOpening(char c){
        return c == '(' || c == '['  || c == '{';
    }

    boolean isCorrectNesting(char start, char end){
        return (start == '(' && end == ')') ||
            (start == '[' && end == ']') ||
            (start == '{' && end == '}');
    }
}
