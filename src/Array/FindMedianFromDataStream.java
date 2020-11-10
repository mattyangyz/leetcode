package Array;

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

// 这题思路是用一个left和right来存比较，左边是一个maxHeap 存小点的数，右边是一个minHeap 存大点的数。
// https://www.youtube.com/watch?v=cqhED6Xgy9Y
// 关键点在于存第一个数的时候存左边右边都可以，但是存第二个数的时候就要对比之前存的第一个数看是否需要swap。
// 每加一次都要求rebalance，保证两边的长度绝对值不超过一。
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        FindMedianFromDataStream median = new FindMedianFromDataStream();
        median.addNum(2);
        median.addNum(3);
        median.findMedian();
    }

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        left = new PriorityQueue<>((a, b) -> (b - a));
        right = new PriorityQueue<>();
    }

    // 第一个和第二个num需要特别的处理
    public void addNum(int num) {
        if (left.size() == 0 && right.size() == 0) {  // 这是add第一个num，放左边
            left.offer(num);
            return;
        }

        if (right.size() == 0) {          // 这是放第二个num，要检查是否比左边的(第一个)要下，若果是的话就交换
            if (num < left.peek()) {
                right.offer(left.poll());
                left.offer(num);
                return;
            }
            right.offer(num);
            return;
        }

        if (num < right.peek()) {
            left.offer(num);
        } else{
            right.offer(num);
        }
        balance(left, right);
    }

    private void balance(PriorityQueue left, PriorityQueue right) {
        if (Math.abs(left.size() - right.size()) > 1) {
            if (left.size() > right.size()) {
                right.offer(left.poll());
                return;
            } else {
                left.offer(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (right.size() > left.size()) {
            return right.peek();
        } else {
            double a = left.peek();
            double b = right.peek();
            return (a + b) / 2.0;
        }
    }
}