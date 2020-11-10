package Hard;

import java.util.HashMap;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * <p>
 * 思路: 1 2 3   5 6 7, 这时候放入4，她连续的空间是left + right + 1， 为什么左边的 3 能反应最新的连续 因为左右
 * 边界会被更新的，在map.put(n-left, sum）这里。
 */

// hashmap
public class LongestConsecutiveSequence {

    public int longestConsectuve(int[] num) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : num) {

            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);

                res = Math.max(res, sum);

                map.put(n - left, sum);
                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}
