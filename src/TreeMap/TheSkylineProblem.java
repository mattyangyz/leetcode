package TreeMap;

import java.util.*;

/**
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * Buildings Skyline Contour
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively,
 * and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
 * that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point,
 * where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also,
 * the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 * <p>
 * <p>
 * <p>
 * 思路: https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
 * <p>
 * 起始点 最高点 / 终止点 第二高点。只会用到最高的点和第二高的点。 如果是进入事件的话 记录一下最高的大楼是谁，如果是离开的事件
 * 的话 记录一下第二高的点是哪个。Edge case: int[] one = new int[]{2, 5, 10}; int[] two = new int[]{5, 7, 15}; int[] three = new int[]{8, 15, 5};
 * 这样的话，先把[5 -15]处理了 再处理[5,10] 根据排序的性质 可以handle这个edge case。
 * <p>
 * (1) 自建一个名为Height的数据结构，保存一个building的index和height。约定，当height为负数时表示这个高度为height的building起始于index；height为正时表示这个高度为height的building终止于index。
 * <p>
 * (2) 对building数组进行处理，每一行[ Li, Ri, Hi ]，根据Height的定义，转换为两个Height的对象，即，Height(Li, -Hi) 和 Height(Ri, Hi)。 将这两个对象存入heights这个List中。
 * <p>
 * (3) 写个Comparator对heights进行升序排序，首先按照index的大小排序，若index相等，则按height大小排序，以保证一栋建筑物的起始节点一定在终止节点之前。
 * <p>
 * (4) 将heights转换为结果。使用PriorityQueue对高度值进行暂存。遍历heights，遇到高度为负值的对象时，表示建筑物的起始节点，此时应将这个高度加入PriorityQueue。
 * 遇到高度为正值的对象时，表示建筑物的终止节点，此时应将这个高度从PriorityQueue中除去。且在遍历的过程中检查，当前的PriorityQueue的peek()是否与上一个iteration的peek()值（prev）相同，
 * 若否，则应在结果中加入[当前对象的index, 当前PriorityQueue的peek()]，并更新prev的值。
 */

public class TheSkylineProblem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();

        // 结果是 [2,9,10] [3,7,15] [5,12,12] [15,20,10] [19,24,8]
        // [2,-10] [3,-15] [5,-12] [7,15] [9,10] [12,12] [15,-10] [19,-8] [20,10] [24,8]
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});  // 起始点 高度是为负的
            heights.add(new int[]{building[1], building[2]});   // 终点   高度是为正的
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]); //按照x坐标来排序

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        queue.offer(0);
        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {            // 进入事件
                queue.offer(-height[1]);
            } else {                           // 离开事件
                queue.remove(height[1]);
            }
            // the current max height in all encountered buildings
            int curHighest = queue.peek();// 1. 进入事件 如果cur != prev 说明现在的比之前的要高，可以加入。如果等于，说明对于当前的点，之前的还是最大的 刚刚push进去的是小的。
            // if the max height is different from previous one, that means a critical point is met, add to result list.
            if (prev != curHighest) {// 2. 离开事件 如果cur != prev 说明最高的已经移除 现在的这个是第二高 可以加入。
                res.add(new ArrayList<>(Arrays.asList(height[0], curHighest)));
                prev = curHighest;
            }
        }
        return res;
    }
}
