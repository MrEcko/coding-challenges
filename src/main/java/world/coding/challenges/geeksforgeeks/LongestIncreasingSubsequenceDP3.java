package world.coding.challenges.geeksforgeeks;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 */
public class LongestIncreasingSubsequenceDP3 {

    /**
     * Iterative function to find length of longest increasing sub-sequence of given array
     */
    public static int LIS(int[] A) {
        // array to store sub-problem solution. L[i] stores the length
        // of the longest increasing sub-sequence ends with A[i]
        int[] L = new int[A.length];

        // longest increasing sub-sequence ending with A[0] has length 1
        L[0] = 1;

        // start from second element in the array
        for (int j = 1; j < A.length; j++) {
            // do for each element in sub-array A[0..j-1]
            for (int i = 0; i < j; i++) {
                // find longest increasing sub-sequence that ends with A[i]
                // where A[i] is less than the current element A[j]
                if (A[i] < A[j] && L[i] > L[j]) {
                    L[j] = L[i];
                }
            }
            // include A[j] in LIS
            L[j]++;
        }

        // return longest increasing sub-sequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }

    static int max_ref; // stores the LIS

    /* To make use of recursive calls, this function must return
    two things:
    1) Length of LIS ending with element arr[n-1]. We use
       max_ending_here for this purpose
    2) Overall maximum as the LIS may end with an element
       before arr[n-1] max_ref is used this purpose.
    The value of LIS of full array of size n is stored in
    *max_ref which is our final result */
    static int _lisDynamic(int arr[], int n)
    {
        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */
        for (int i = 1; i < n; i++)
        {
            res = _lisDynamic(arr, i);
            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }

        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }

    // The wrapper function for _lis()
    static int lisDynamic(int arr[], int n)
    {
        // The max variable holds the result
        max_ref = 1;

        // The function _lis() stores its result in max
        _lisDynamic( arr, n);

        // returns max
        return max_ref;
    }


    /* To make use of recursive calls, this function must return
    two things:
    1) Length of LIS ending with element arr[n-1]. We use
       max_ending_here for this purpose
    2) Overall maximum as the LIS may end with an element
       before arr[n-1] max_ref is used this purpose.
    The value of LIS of full array of size n is stored in
    *max_ref which is our final result */
    static int _lis(int arr[], int n) {
        if (n == 1) System.out.println("n=1 => LIS 1");

        // base case
        if (n == 1)
            return 1;

        // 'max_ending_here' is length of LIS ending with arr[n-1]
        int res, max_ending_here = 1;

        /* Recursively get all LIS ending with arr[0], arr[1] ...
           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
           max ending with arr[n-1] needs to be updated, then
           update it */

        for (int i = 1; i < n; i++) {
            res = _lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
                max_ending_here = res + 1;
        }
        // Compare max_ending_here with the overall max. And
        // update the overall max if needed
        if (max_ref < max_ending_here)
            max_ref = max_ending_here;

        // Return length of LIS ending with arr[n-1]
        return max_ending_here;
    }


    static int lis(int[] arr, int n) {
        // The max variable holds the result
        max_ref = 1;

        // The function _lis() stores its result in max
        _lis(arr, n);

        // returns max
        return max_ref;
    }

}
