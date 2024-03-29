package Array.Range;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 *
 * Example:
 *
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 *
 *
 *
 * 思路: 就是一个实现题，没有什么需要特别考虑的，就是要注意分开三段来考虑！
 *
 * Find the range between lower and first element in the array.
 * Find ranges between adjacent elements in the array.
 * Find the range between upper and last element in the array.
 */

public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower) {
            result.add(formRange(lower, nums[0] - 1));
        }

        // 2nd step
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i] + 1) {
                result.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // 3rd step
        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    public String formRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }
}
