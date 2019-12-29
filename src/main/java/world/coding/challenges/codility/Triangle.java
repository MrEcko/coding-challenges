package world.coding.challenges.codility;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] A) {
        //0<=P<Q<R<N
        //a=A[P], b=A[Q], c=A[R]
        //a+b>c  (1)
        //a+c>b  (2)
        //b+c>a  (3)
        // sorting guarantees (2) and (3)
        // picking adjacent values makes (1) most likely
        // => sort and check for (1) in [P,P+1,P+2]

        int output = 0;
        int n = A.length;
        Arrays.sort(A);
        if (n>2){
            for (int p=0; p<n-2; p++){
                int a = A[p];
                int b = A[p+1];
                int c = A[p+2];
                if ((long)a+b>c){
                    output++;
                    break;
                }
            }
        }
        return output;
    }
}
