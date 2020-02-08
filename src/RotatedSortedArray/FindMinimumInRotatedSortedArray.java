package RotatedSortedArray;


/**
 * The minimum element must satisfy one of two conditions: 1) If rotate, A[min] < A[min - 1]; 2) If not, A[0].
 * Therefore, we can use binary search: check the middle element, if it is less than previous one, then it is minimum.
 * If not, there are 2 conditions as well: If it is greater than both left and right element,
 * then minimum element should be on its right, otherwise on its left.
 * <p>
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */


public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[end]) {  // 拿 mid 跟 end 比较先， 不能拿start跟mid 比较先， 因为考虑 1, 2, 3, <4>, 5, 6, 7 和
                // 7, 1, 2, <3>, 4, 5, 6
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
