package world.coding.challenges.codility;

/**
 * https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
 */
public class Ladder {
    public int[] solution(int[] A, int[] B) {
        int L = A.length;

        int max = 0;
        for (int i = 0; i < L; i++) {
            max = Math.max(A[i], max);
        }
        int[] fibonacci = new int[max+1]; // plus one for "0"
        fibonacci[0] =1;
        fibonacci[1] =1;

        for(int i=2; i<= max; i++){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % (1 << 30);
            // we want to find the result of "a number modulo 2^P"
            // if we first let the number modulo 2^Q (Q > P)
            // then, modulo 2^P, the esult is the same.
            // So, "we first modulo 2^30" to avoid overflow
            // where, 2^30 == 1 << 30
        }

        int[] output = new int[L];

        for(int i=0; i<L; i++){
            output[i] = fibonacci[A[i]] % (1 << B[i]); // where, "1 << B[i]" means 2^B[i]
        }

        return output;
    }
}
