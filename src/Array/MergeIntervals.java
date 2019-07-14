package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 *
 * 注意： int[][] 的 comparator 是怎么写的， 然后怎么从list转换成int[][]
 *
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] prevInterval = intervals[0];
        result.add(prevInterval);   //TODO: 先把这个加进去先， 然后再改

        for (int[] interval : intervals) {
            if (interval[0] <= prevInterval[1]) { // overlap
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
            else {
                prevInterval = interval;
                result.add(prevInterval);
            }
        }
        return result.toArray(new int[result.size()][]);    // TODO: 注意这个如何转换
    }
}
