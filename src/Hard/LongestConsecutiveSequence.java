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
 * 思路: 1 2 3   5 6 7, 这时候放入4，她连续的空间是left的连续空间 + right的连续空间 + 1， 为什么左边的 3 能反应最新的连续 因为左右
 * 边界会被更新的，但是其中的元素就不需要。更新连续空间在map.put(n-left, sum）这里，同时也可以更新当中全部的连续空间，但没有必要。答案都是一样的。
 */

// hashmap
public class LongestConsecutiveSequence {

    public static void main(String[] args){
        longestConsectuve(new int[]{100, 4, 200, 1, 3, 2});
    }

    public static int longestConsectuve(int[] num) {

        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : num) {

            if (!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

                int sum = left + right + 1;
                map.put(n, sum);
                res = Math.max(res, sum);

                for(int i = n; i >= n - left; i--){
                    map.put(i, sum);
                }
                for(int i = n; i <= n + right; i++){
                    map.put(i, sum);
                }
//                map.put(n - left, sum);           // 其实这样就可以了，更新一头一尾，但是上面两个for loop的更好理解。
//                map.put(n + right, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}
