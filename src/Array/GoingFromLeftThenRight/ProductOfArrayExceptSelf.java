package Array.GoingFromLeftThenRight;

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

    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {  // 正常就行，左边到右边。 第一个肯定是一。
            res[i] = nums[i - 1] * res[i - 1];
        }


        int right = 1;                         // 右边到左边的话，就需要一个额外的var，去记录之前 nums[i + 1] * right;
        for (int i = nums.length - 2; i >= 0; i--) {

            right = nums[i + 1] * right;
            res[i] = right * res[i];
        }

        return res;
    }

    public int[] productExceptSelfMostOptVersion(int[] nums) {      // 这个是最优解法！

        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i < nums.length; i++){
            left[i] = nums[i - 1] * left[i - 1];
        }
        int prev = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            left[i] = prev * left[i];
            prev *= nums[i];
        }

        return left;
    }
}
