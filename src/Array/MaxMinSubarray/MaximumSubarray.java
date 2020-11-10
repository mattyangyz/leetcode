package Array.MaxMinSubarray;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 *
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 思路：
 * 用memo保存之前的结果。如果之前的i-1结果为-1， 则不取i-1的结果；当前位置的memo[i]直接去nums[i]的，如果之前的为正的，则取之前的结果。
 *
 */

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {     // 这个是用memo来解决的
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (memo[i - 1] < 0) {
                memo[i] = nums[i];
            } else {
                memo[i] = nums[i] + memo[i - 1];
            }
            res = Math.max(memo[i], res);
        }
        return res;
    }

    public static int maxSubArrayOneVar(int[] nums) {
        int prev = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev < 0) {
                prev = nums[i];
            } else {
                prev = prev + nums[i];
            }
            res = Math.max(prev, res);
        }
        return res;
    }
}
