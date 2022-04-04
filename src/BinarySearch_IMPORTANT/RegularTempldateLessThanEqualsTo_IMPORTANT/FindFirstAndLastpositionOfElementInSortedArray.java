package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;


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
 * 思路: 两个正常的binary search，就是 == target的时候要偏左或偏右这样去对待，其他情况都是跟正常的一样的。
 */

public class FindFirstAndLastpositionOfElementInSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }


    private static int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                high = mid - 1;
                index = mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return index;
    }

    private static int findLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                low = mid + 1;
                index = mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return index;
    }
}
