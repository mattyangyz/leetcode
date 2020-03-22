package Array.Interval;

import java.util.Arrays;

/**
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 * <p>
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 * <p>
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * <p>
 * <p>
 * Note:
 * <p>
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * <p>
 * 思路: 先进行排序， 然后根据排序的结果一个个去遍历。 如果当前的比之前的end要 >= 的话，就算如果结果count里面，
 * 最后用本来的长度减去结果count看有多少个被remove掉。
 */

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); //   从小到大去排序
        int end = intervals[0][1];
        // 算最后能剩下多少个interval
        int count = 1;                                   //   数剩下来有多少个interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {                  // only count if the second one is greater than the first one
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
