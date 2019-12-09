package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 * <p>
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * <p>
 * 思路： 利用map.containsKey(entry.getKey() + k)去巧妙地避开dup，同时map的key是数字以及频率。
 * 避免dup这个是关键在这一题里面。
 */

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();                    // 数字出现的个数
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {          // 这个可以避免dup
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    res++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {                  // 巧妙的是这样去avoid dup
                    res++;
                }
            }
        }
        return res;
    }
}
