package Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/** Linkedin
 *
 * 注意： int[][] 的 comparator 是怎么写的， 然后怎么从list转换成int[][].
 * 先把intervals[0]加进去， 然后从第二个开始比较。
 * 两种情况 1, 当前元素[0]小于prev[1]， 去元素[1]或prev[1]的最大值
 *         2, 反之，把现在的interval变成prev，然后把它加入到list里面， 然后再渠道下一个元素 重复1的步骤。
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
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 */

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.get(list.size() - 1)[1]) {
                list.get(list.size() - 1)[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
            } else {
                list.add(intervals[i]);
            }
        }

        int[][] result = new int[list.size()][2];
        int i = 0;
        for (int[] array : list) {
            result[i++] = array;
        }
        return result;
    }

}
