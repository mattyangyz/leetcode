package SlidingWindow;

import java.util.PriorityQueue;

/**
 * Deque
 * <p>
 * peek -> retrieve the ehad of this queue
 * pool -> retrieve and removes the head of this queue
 */

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }

    class Unit {
        int index;
        int value;

        public Unit(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Unit> queue = new PriorityQueue<>((n1, n2) -> n2.value - n1.value);
        int length = nums.length;
        int ansLength = length - k + 1;
        int count = 0;
        int[] ans = new int[ansLength];
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            if (count < k) {
                while (!queue.isEmpty() && queue.peek().value <= cur) {
                    queue.poll();
                }
                queue.offer(new Unit(i, cur));
                count++;
                if (count == k) {
                    ans[0] = queue.peek().value;
                }
            } else {
                int head = nums[i - k];
                while (!queue.isEmpty() && (queue.peek().value <= cur || queue.peek().index <= i - k)) {
                    queue.poll();
                }
                queue.offer(new Unit(i, cur));
                ans[i - k + 1] = queue.peek().value;
            }
        }
        return ans;
    }
}
