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

// 这个版本是新写的，很好理解的。
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(intervals[0][0]);
        first.add(intervals[0][1]);
        res.add(first);

        for(int i = 1; i < intervals.length; i++){

            if(intervals[i][0] <= res.get(res.size() - 1).get(1)){
                int newEnd = Math.max(res.get(res.size() - 1).get(1), intervals[i][1]);
                res.get(res.size() - 1).add(1, newEnd);
            }
            else{
                List<Integer> innerList = new ArrayList<>();
                innerList.add(intervals[i][0]);
                innerList.add(intervals[i][1]);
                res.add(innerList);
            }
        }

        int[][] matrix = new int[res.size()][];
        int index = 0;
        for(List<Integer> innerList: res){
            int[] innerMatrix = new int[2];
            innerMatrix[0] = innerList.get(0);
            innerMatrix[1] = innerList.get(1);
            matrix[index++] = innerMatrix;
        }
        return matrix;
    }

}
