package BinarySearch.RegularTempldateLessThanEqualsTo;


/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * <p>
 * 思路: 正常的binary search加上 +-0.5 去做，但是要知道找出来的start 和 end index怎么确定最后的位置，这个要细想。
 */

public class FindFirstAndLastpositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        int left = binarySearch(nums, target - 0.5);
        int right = binarySearch(nums, target + 0.5);
        if (right == left) {                            // 只有一个元素出现，没有两个。
            return res;
        }
        res[0] = left;
        res[1] = right - 1; // 想想 5, 7, 7, 8, 8, 8, 10 找8.5最后会落到left 8 10 right这里，然后start和end都会等于10，最后end会等于8的index，这样
        // 违反while loop就结束，我们应该拿end的位置，所以要返回的结果 -1。
        return res;

    }

    // 这里的binary search不需要找一个具体的值
    private static int binarySearch(int[] nums, double target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
