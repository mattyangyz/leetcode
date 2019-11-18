package Array.RotatedSortedArray;

/**
 * 1, 3, 1, 1, 1
 * |
 */

public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (start + (end + start)) / 2;
            System.out.println(mid);
            if (nums[mid] == target) {
                return true;
            }

            //if left part is sorted
            if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[start] == nums[mid]) {                  // think about 1, 3, 1, 1, 1
                end--;
            } else {                                               // if right is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
