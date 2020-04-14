package world.coding.challenges.leetcode.easy;

/**
 * https://leetcode.com/problems/delete-columns-to-make-sorted/
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int output = 0;
        if (A.length>1){
            int n = A[0].length();
            for (int i=0; i<n; i++){
                for (int row = 0; row < A.length-1; row++){
                    if (A[row].charAt(i) > A[row+1].charAt(i)){
                        output++;
                        break;
                    }
                }
            }
        }
        return output;
    }
}
