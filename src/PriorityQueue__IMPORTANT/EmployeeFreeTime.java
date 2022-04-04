package PriorityQueue__IMPORTANT;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * We are given a list schedule of employees, which represents the working time for each employee.
 * <p>
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 * <p>
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 * <p>
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 * <p>
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 * <p>
 * <p>
 * 思路: 思考一下用priorityQueue排序好了之后， poll出来会是怎么样的。line 51的comment很关键，要想明白。
 */

// 1 - 10  2 13


public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {

        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);

        for (List<Interval> list : avails) {
            for (Interval interval : list) {
                pq.add(interval);
            }
        }

        Interval prev = pq.poll();
        while (!pq.isEmpty()) {
            // 因为pq是排序的， 所以只要pq.peek出来的start比prev.end大 后面的也都会比prev.end大
            // 要细细思考下这里
            if (prev.end < pq.peek().start) {
                result.add(new Interval(prev.end, pq.peek().start));
                prev = pq.poll(); // 变成下一个prev.
            } else {
                //  这里不需要考虑start的，因为下一个start肯定是比这个start要后面的，要考虑end的大小 看哪个更大，更大那个会影响
                // 下一个start
                prev = prev.end > pq.peek().end ? prev : pq.peek();
                pq.poll();
            }
        }
        return result;
    }


    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    ;
}
