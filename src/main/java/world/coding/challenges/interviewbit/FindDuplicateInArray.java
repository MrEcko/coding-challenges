package world.coding.challenges.interviewbit;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class FindDuplicateInArray {
    public int repeatedNumber(final List<Integer> A) {
        if (A == null || A.size() == 0) return -1;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (set.contains(a)) return a;
            else set.add(a);
        }
        return -1;
    }
}
