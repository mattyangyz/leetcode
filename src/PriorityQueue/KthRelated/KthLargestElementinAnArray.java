package PriorityQueue.KthRelated;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

// 第一种做法是用sort，第二种是prioriyqueue
public class KthLargestElementinAnArray {

    public static void main(String[] args) {
        KthLargestElementinAnArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k) { // 这里注意不能 == 的时候pull呀，万一刚好 == 后就结束 而刚好这个 == 的结果就是我们要的target呢
                queue.poll();
            }
        }
        return queue.poll();
    }


    public int findKthLargestSort(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }
}
