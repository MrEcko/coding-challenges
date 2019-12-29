package world.coding.challenges.codility;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/distinct/
 */
public class Distinct {

    /**
     * @param A  array A
     * @return 1 if array {@param A} is a permutation and 0 if it is not.
     * A permutation is a sequence containing each element from 1 to N once, and only once.
     */
    public int solution(int[] A) {
        return IntStream.of(A).boxed().collect(Collectors.toSet()).size();
    }
}
