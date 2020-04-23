package world.coding.challenges.leetcode.challenge30days;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        return adaptedBinarySearch(nums, 0, n - 1, target);
//        return anotherSearch(nums,target);
    }

    int adaptedBinarySearch(int[] arr, int low, int high, int target) {

        if (high >= low) {
            int mid = low + (high - low) / 2;
            int midEl = arr[mid];
            if (midEl == target)
                return mid;
                //high is ascending, as expected
            else if (target > midEl && target <= arr[high]) return adaptedBinarySearch(arr, mid + 1, high, target);
                //low is descending, as epsected
            else if (arr[low] <= target && target < midEl)
                return adaptedBinarySearch(arr, low, mid - 1, target);

            else if (midEl < arr[low]) return adaptedBinarySearch(arr, low, mid - 1, target);
            else return adaptedBinarySearch(arr, mid + 1, high, target);
        }

        return -1;
    }

    int anotherSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) return mid;

            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return arr[low] == target ? low : -1;
    }
}
