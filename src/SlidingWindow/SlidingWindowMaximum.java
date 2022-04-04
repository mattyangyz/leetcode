package SlidingWindow;

import java.util.PriorityQueue;

/**
 * Deque
 * <p>
 * peek -> retrieve the ehad of this queue
 * pool -> retrieve and removes the head of this queue
 */

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < k; ++i) {
            pq.add(new int[] { nums[i], i });
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = pq.peek()[0];
        int j = 1;

        for (int i = k; i < nums.length; ++i) {
            pq.add(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {             // 这里是创建window的关键，而且为什么要用while了，应为思考这种情况 15， 16， 14， 3， 2
                pq.poll();
            }
            ans[j++] = pq.peek()[0];
        }
        return ans;
    }
}
