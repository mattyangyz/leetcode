package BinarySearch;

public class MissingElementInSortedArray {

    public static int missingElement(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        // nums[length - 1] - nums[0] 得到这个array的范围线，然后减去这个array的size就知道
        // 有多少个element是missing的
        int amountOfMissingInArray = nums[length - 1] - nums[0] + 1 - length;

        if (amountOfMissingInArray < k) { // 这个missing的number肯定在array的最后一个element的后面
            return nums[length - 1] + (k - amountOfMissingInArray); // 减去之前的amount，得到新的amount从array的右边开始
        }

        while (left <= right) {
            int middle = left + (right - left) / 2;
            // 计算左边到中间有多少个missingNumber
            // (nums[middle] - nums[left] + 1) 计算有多少个数
            // (middle - left + 1) 计算有多少个index在这范围里面
            int missingAmount = (nums[middle] - nums[left] + 1) - (middle - left + 1);
            if (missingAmount != 0) {
                if (missingAmount >= k) {
                    right = middle - 1;
                } else {
                    k -= missingAmount;
                    left = middle + 1;
                }
            } else {
                break;
            }
        }
        return nums[right] + k;
    }

    public static int missingElementRegular(int[] nums, int k) {
        int target = nums[0] + k;
        int l = 0, r = nums.length - 1, prevMid = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return target + mid - prevMid;
            else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                target += (mid - prevMid);
                prevMid = mid;
                l = mid + 1;
            }
        }
        return target;
    }

}
