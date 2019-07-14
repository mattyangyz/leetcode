package Array;

/**
 *
 * 238. Product of Array Except Self
 * Medium
 *
 * 2350
 *
 * 197
 *
 * Favorite
 *
 * Share
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * left and right two temp variables are needed.
 *
 * from left to right
 * then from right to left. for the fist item on each side, set it to one.
 *
 *
 */

public class ProductOfArrayExceptSelf {

    public int[] productExceptSefl(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = ans[i - 1] * nums[i - 1];
            }
            ans[i] = left;
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = ans[i - 1] * nums[i + 1];
            }
            ans[i] *= right;
        }
        return ans;
    }
}
