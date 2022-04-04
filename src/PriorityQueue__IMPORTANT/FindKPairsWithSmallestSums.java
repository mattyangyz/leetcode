package PriorityQueue__IMPORTANT;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * <p>
 * 思路: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
 */

public class FindKPairsWithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
        List<int[]> res = new ArrayList<>();

        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 == 0 || N2 == 0) {
            return res;
        }
        // offer initial pairs {num1, num2, index_of_num2}
        for (int i = 0; i < Math.min(N1, k); k++) {
            queue.offer(new int[]{nums1[i], nums2[i], 0});
        }

        // get 1st k elem into result, each time, offer potential better pairs into queue
        // if there r not enough pair, just return all pairs
        for (int i = 0; i < Math.min(N1 * N2, k); i++) {
            int[] cur = queue.poll();
            res.add(new int[]{cur[0], cur[1]});

            // next better pair could with be A: {after(num1), num2} or B: {num1. after(num2)}
            // for A, we've already added top possible k into queue, so A is either in the queue already, or not qualified
            // for B, it might be a better choice, so we offer it into queue
            if (cur[2] < N2 - 1) {
                int index = cur[2] + 1;
                queue.offer(new int[]{cur[0], nums2[index], index});
            }
        }
        return res;
    }
}
