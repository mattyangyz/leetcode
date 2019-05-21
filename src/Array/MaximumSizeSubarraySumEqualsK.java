package Array;

import java.util.HashMap;

// TODO: NOT yet
/**
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 *
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 *
 * Example 2:
 * Given nums = [-2, -1, 2, 1], k = 1,
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 *
 * Follow Up:
 * Can you do it in O(n) time?
 *
 *
 */


public class MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] sum = new int[n + 1];
        int ans = 0;
        map.put(k, 0);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            if(map.containsKey(sum[i])){
                ans = Math.max(ans, i - map.get(sum[i]));
            }
            if (!map.containsKey(sum[i] + k)) {
                map.put(sum[i] + k, i);
            }
        }
        return ans;
    }
}
