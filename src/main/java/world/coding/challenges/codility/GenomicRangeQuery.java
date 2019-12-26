package world.coding.challenges.codility;

import java.util.*;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P, Q is an integer within the range [0..N − 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 */
public class GenomicRangeQuery {

    private static final Map<Character,Integer> NUCLEOTIDE_IMPACT_FACTORS;
    static {
        Map<Character,Integer> map = new HashMap();
        map.put('A',1);
        map.put('C',2);
        map.put('G',3);
        map.put('T',4);
        NUCLEOTIDE_IMPACT_FACTORS = Collections.unmodifiableMap(map);
    }

    /**
     * @param S string lenght N [1..100,000] with A,C,G,T (impact 1,2,3,4)
     * @param P array of length M [1..50,000] with values [0..N-1]
     * @param Q array of length M [1..50,000] with values [0..N-1]
     *          P[K]<=Q[K] ; 0<=0<M
     * @return array with M integers with min impact factor for each query
     */
    public int[] solution(String S, int[] P, int[] Q) {
        // return efficientSolution(S,P,Q);
        return bruteForceSolution(S,P,Q);
    }

    public int[] efficientSolution(String S, int[] P, int[] Q) {
        //input validatin goes here - to do NPEs or IllegalArgumentException
        int M = P.length;
        int[] solution = new int[M];
        int[] input = computeImpactFactors(S);
        //System.out.println(Arrays.toString(input));
        //  0  1  2  3  4  5  6
        // [2, 1, 3, 2, 2, 4, 1]


        // => mins
        // need to scan it somehow
        //[0, 2, 1, 1, 1, 1, 1, 1]
        // [1, 1, 1, 1, 1, 1, 1, 0]

        //brute force (N^2)
        for (int k=0; k < M; k++){
            int left = P[k];
            int right = Q[k];
            //[2,4], [5,5], [0,6]
            int min = input[left];
            for (int i=left+1; i<=right; i++){
                if (input[i]<min){
                    min = input[i];
                }
            }
            //System.out.println("["+left+","+right+"] min is " + min);
            solution[k] = min;
        }
        //assumptions
        //P.length == M.length
        return solution; // [2,4,1]
    }

    public int[] bruteForceSolution(String S, int[] P, int[] Q) {
        //input validatin goes here - to do NPEs or IllegalArgumentException
        int M = P.length;
        int[] solution = new int[M];
        int[] input = computeImpactFactors(S);

        for (int k=0; k < M; k++){
            int left = P[k];
            int right = Q[k];
            int min = input[left];
            for (int i=left+1; i<=right; i++){
                if (input[i]<min){
                    min = input[i];
                }
            }
            solution[k] = min;
        }
        return solution;
    }

    private int[] computeImpactFactors(String dnaSequence){
        int[] factors = new int[dnaSequence.length()];
        for (int i=0; i < dnaSequence.length(); i++){
            char c = dnaSequence.charAt(i);
            factors[i] = NUCLEOTIDE_IMPACT_FACTORS.get(c);
        }
        return factors;
    }
}
