package SlidingWindow.SlidingWindowSubstringSearch;


/**
 * Given an array of n positive integers and positive integer s, find the minimal length of a contiguous subarray of
 * which the sum >= s. if there isn't one, return 0 instead.
 *
 * we could move the starting index of the current subarray as soon as
 * we know that no better could be done with this index as the starting index.
 * We could keep 2 pointer,one for the start and another for the end of the current subarray,
 * and make optimal moves so as to keep the sum greater than s as well as maintain the lowest size possible.
 *
 */

public class MinimumSizeSubarraySum {

    public int solveWithN(int s, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


}
