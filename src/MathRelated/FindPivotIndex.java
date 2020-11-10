package MathRelated;


/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
 * <p>
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * <p>
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * <p>
 * 思路: 先走一次计算一次所有的sum先，然后再走一次。
 * 要注意处理这种情况 [-1,-1,-1,0,1,1]， 结果是 0 而不是 -1.
 */

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {

            if (i != 0) {               // 不算当前的i
                left += nums[i - 1];
            }

            if (left == sum - left - nums[i]) { // sum减去左边的和当前的i。
                return i;
            }
        }
        return -1;
    }
}
