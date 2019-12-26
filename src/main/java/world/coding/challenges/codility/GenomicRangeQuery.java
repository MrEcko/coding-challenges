package world.coding.challenges.codility;

import java.util.*;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
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
