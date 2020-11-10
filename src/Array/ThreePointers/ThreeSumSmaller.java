package Array.ThreePointers;

import java.util.Arrays;


/**
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,0,1,3], and target = 2
 * Output: 2
 * Explanation: Because there are two triplets which sums are less than 2:
 * [-2,0,1]
 * [-2,0,3]
 * Follow up: Could you solve it in O(n2) runtime?
 */

// 跟 3sum的思路一模一样，要理解的地方就是 为什么是re += right - left这里。
// 因为只要这个right满足了，所有在左边的element都满足， x y z1 z2 z3, x + y + z3满足了，可以推倒出 x + y + z1, z2, z3都满足
public class ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
