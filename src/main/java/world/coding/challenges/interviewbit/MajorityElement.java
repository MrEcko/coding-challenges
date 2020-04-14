package world.coding.challenges.interviewbit;

import java.util.Collections;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        int n = A.size();
        int minCount = n/2;
        if (n==1) return A.get(0);
        Collections.sort(A);
        int currentElement = A.get(0);
        int occurences = 1;
        for (Integer el : A){
            if (el == currentElement) {
                occurences++;
                if (occurences > minCount) return el;
            } else {
                currentElement = el;
                occurences = 1;
            }
        }
        return -1;
    }

    /**
     * Principle - take 2 different elements x and y  , x!=y
     * if you remove them from the array the majority element does not  change
     */
    public int majorityElementEditorial(final List<Integer> A) {
        int elem=A.get(0);
        int count=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i)==elem){
                count++;
            }else{
                count--;
            }
            System.out.println("El " + elem + " count " + count);
            if(count==0){
                elem=A.get(i);
                count=1;
                System.out.println("New El " + elem + " count " + count);
            }
        }
        return elem;
    }
}
