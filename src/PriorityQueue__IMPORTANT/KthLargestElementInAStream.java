package PriorityQueue__IMPORTANT;

import java.util.PriorityQueue;


/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * 思路: 用一个min heap去做， 每次heap里面保留k个元素 然后当size超过的时候 用value跟peek/poll出来的比较
 * 如果是大于的话 就poll出来，然后把value加进去。
 */


public class KthLargestElementInAStream {

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;


    public KthLargestElementInAStream(int k, int[] num) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : num) {
            add(n);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {        // 保证前K个value就是kth largest的。
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }
}
