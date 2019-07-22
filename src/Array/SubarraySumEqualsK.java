package Array;

import java.util.HashMap;

/**
 * https://zhuanlan.zhihu.com/p/32854569
 * <p>
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, -1, 5, -2, 3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 * Example 2:
 * <p>
 * Input: nums = [-2, -1, 2, 1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 * <p>
 * <p>
 * <p>
 * The HashMap stores the sum of all elements before index i as key, and i as value. For each i,
 * check not only the current sum but also (currentSum - previousSum) to see if there is any that equals k,
 * and update max length.
 * <p>
 * The keypoint is what the map.containsKey(sum - k) .
 * Here’s an example: Let’s say you’ve iterated to index 5 (randomly chosen) and your sum from index 0 to 5 so far is 7,
 * and k is 3. sum - k in this case is 4. What map.containsKey(sum - k)
 * returns is the index where the sum of every element up to that index from index 0 is sum - k, or (7 - 3) == 4,
 * in our example. Let’s say that that index returned by map.containsKey(sum - k) is 2 (randomly chose one that is before index 5).
 * So knowing that at index 2 the total sum is 4, and at index 5, the total sum is 7,
 * that means the elements between index 2 and index 5 incremented the total sum by 3, or k!
 * <p>
 * 用HashMap, Key指i及之前元素的总和，value指index。
 * <p>
 * 对于每个i，不仅检查当前sum，也要检查(currentSum - previousSum)来看看是否与k相等。对map.containsKey(sum - k) 的理解是一个重点：
 */


public class SubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)) {
                max = Math.max(i - map.get(sum - k), max);
            }
            if (!map.containsKey(sum)) {                      // this is for [7, 5, 3, -3] always, always take the previous one.
                map.put(sum, i);
            }
        }
        return max;
    }
}
