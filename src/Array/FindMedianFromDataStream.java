package Array;

import java.util.Collections;
import java.util.PriorityQueue;


/**
 *
 * 1, 2, 3, 4, 5 || 6, 7, 8, 9， when left's size is one more than right
 * 1, 2, 3, 4, 5 || 6, 7, 8, 9, 10 when they are equal, then peek from them.
 *
 *
 *
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < right.peek()) {
            left.offer(num);
        }
        else{
            right.offer(num);
        }

        if (left.size() < right.size()) {
            left.offer(right.poll());
        } else if (left.size() - right.size() > 2) {
            right.offer(left.poll());
        }
    }

    public double findMedian() {
        double result = 0;
        if(left.size() == right.size()) {
            result = (left.peek() + right.peek()) * 0.5;
        } else if (left.size() > right.size()) {
            result = left.peek();
        }
        return result;
    }
}