package Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * [1,2], [4,10], [12, 14] intput
 * [3, 16] input
 *
 *
 */

public class InsertInterval {

    public int[][] insertInterval(int[][] intervals, int[] newIntervals) {



        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            res.add(newIntervals);
            return res.toArray(new int[res.size()][]);
        }

        int i =0;
        while (i < intervals.length && intervals[i][1] < newIntervals[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][0] <= newIntervals[1]) {
            newIntervals[0] = Math.min(intervals[i][0], newIntervals[0]);
            newIntervals[1] = Math.max(intervals[i][1], newIntervals[1]);
            i++;
        }
        res.add(newIntervals);
        for (; i < intervals.length; i++) {
            res.add(intervals[i]);
        }
        return res.toArray(new int[res.size()][]);
    }
}
