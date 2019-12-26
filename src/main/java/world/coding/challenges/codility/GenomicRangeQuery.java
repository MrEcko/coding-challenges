package world.coding.challenges.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
     * @param S string length N [1..100,000] with A,C,G,T (impact 1,2,3,4)
     * @param P array of length M [1..50,000] with values [0..N-1]
     * @param Q array of length M [1..50,000] with values [0..N-1]
     *          P[K]<=Q[K] ; 0<=0<M
     * @return array with M integers with min impact factor for each query
     */
    public int[] solution(String S, int[] P, int[] Q) {
        return efficientSolution(S, P, Q);
    }

    public int[] efficientSolution(String S, int[] P, int[] Q) {
        int queriesCount = P.length;
        int stringLength = S.length();
        int numberOfTypes = NUCLEOTIDE_IMPACT_FACTORS.size();

        //represent input as a matrix - each row is a type
        // each type is a vector where the index is the impact (e.g. A with impact 1 is [1, 0, ... ,0 ])
        int[][] inputMatrix = new int[stringLength][numberOfTypes];
        for (int N = 0; N < stringLength; N++) {
            int impact = NUCLEOTIDE_IMPACT_FACTORS.get(S.charAt(N));
            inputMatrix[N][impact - 1] = 1;
        }
        printMatrix(inputMatrix);

        int[][] prefixSum = new int[stringLength+1][numberOfTypes];
        for (int i = 1; i < stringLength+1; i++) {
            int impact = NUCLEOTIDE_IMPACT_FACTORS.get(S.charAt(i-1));
            int impactIndex = impact-1;
            for (int j = 0; j < numberOfTypes; j++) {
                // P[k] = P[k-1]+a[k-1]     - except j is needed because java doesn't sum vectors directly
                prefixSum[i][j] = prefixSum[i - 1][j] + inputMatrix[i-1][j];
                if (j == impactIndex){
                    prefixSum[i][j]++;
                }
            }
        }
        System.out.println("Prefix sum");
        printMatrix(prefixSum);

        //check each slice for min by simple subtraction
        int[] output = new int[queriesCount];
        for (int currentQuery = 0; currentQuery < queriesCount; currentQuery++) {
            int X = P[currentQuery];
            int Y = Q[currentQuery];
            for (int currentType = 0; currentType < numberOfTypes; currentType++) {
                //total of one slice [x,y] is P[Y+1] - P[X]
                if (prefixSum[Y+1][currentType] - prefixSum[X][currentType] > 0) {
                    output[currentQuery] = currentType + 1; //+1 because of index solution
                    break; // first type is minimum impact
                }
            }
        }
        return output;
    }

    private void printMatrix(int[][] matrix) {
        for (int i=0; i<matrix.length;i ++){
            System.out.println(Arrays.toString(matrix[i]));
        }
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
