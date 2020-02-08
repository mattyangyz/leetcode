package Array;


/**
 * Given an array of intergers, find the maximum number of subarrays the array can be split so that each sub array is
 * sorted individually results in a sorted array
 * <p>
 * ex, 3 2 1 5 4 8 9
 * <p>
 * ans: 3
 * <p>
 * subarrays -> 1, 2, 3, | 4, 5 | 8, 9
 */

public class MaximumSubarraySplit {


    public static int getMaxSubarrayCount(int[] a) {
        int n = a.length;
        int minV = a[n - 1];
        int count = 0;
        int temp;

        for (int i = n - 2; i >= 0; i--) {
            temp = Math.min(a[i], minV);
            if (minV != temp) { // find new min
                minV = temp;
                count++;
            }
        }
        return count;
    }
}
