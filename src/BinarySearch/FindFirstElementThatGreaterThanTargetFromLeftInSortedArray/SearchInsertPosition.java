package BinarySearch.FindFirstElementThatGreaterThanTargetFromLeftInSortedArray;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * <p>
 * 题意: 给定一个target，找出对应在sorted array里面的insert position。
 * <p>
 * 思路: 其实就是找第一个大于target的位置，这个就是insert的position。right 不能等于 mid - 1，因为mid有可能是结果。然而left需要mid+1，
 * 因为这个left是小于target的，肯定不是结果 所以可以挪到mid + 1的位置。
 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int right = nums.length;
        int left = 0;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
