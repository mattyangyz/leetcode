package BinarySearch;


/**
 * Most people have figured out the binary search solution but are not able to understand how its working.
 * I will try to explain it simply. What we are essentially doing is going in the direction of the rising slope(by choosing
 * the element which is greater than current). How does that guarantee the result? Think about it, there are 2 possibilities.
 * a) rising slope has to keep rising till end of the array b) rising slope will encounter a lesser element and go down.
 * In both scenarios we will have an answer. In a) the answer is the end element because we take the boundary as -INFINITY
 * b) the answer is the largest element before the slope falls. Hope this makes things clearer.
 * <p>
 * https://leetcode.com/problems/find-peak-element/discuss/50239/Java-solution-and-explanation-using-invariants
 * <p>
 * A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 * Note:
 * <p>
 * Your solution should be in logarithmic complexity.
 */

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
