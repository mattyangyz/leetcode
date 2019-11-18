package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Deque
 * <p>
 * peek -> retrieve the ehad of this queue
 * pool -> retrieve and removes the head of this queue
 */

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] a, int k) {

        if (a == null || k == 0) {
            return new int[0];
        }

        int[] arr = new int[a.length - k + 1];
        int index = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < a.length; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            while (!dq.isEmpty() && a[dq.peekLast()] < a[i]) {
                dq.pollLast();
            }
            dq.offer(i);

            if (i >= k - 1) {
                arr[index++] = a[dq.peek()];
            }
        }
        return arr;
    }
}
