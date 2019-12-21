package Array.TwoDArray;

import java.util.ArrayList;
import java.util.List;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 6
 * <p>
 * Explanation: Given three people living at (0,0), (0,4), and (2,2):
 * The point (0,2) is an ideal meeting point, as the total travel distance
 * of 2+2+2=6 is minimal. So return 6.
 * <p>
 * <p>
 * 思路: https://www.cnblogs.com/grandyang/p/5291058.html
 * 1， 降维 因为x y都是独立的。
 * 2， 然后只看x 和 只看y。
 * <p>
 * 这道题让我们求最佳的开会地点，该地点需要到每个为1的点的曼哈顿距离之和最小，题目中给了我们提示，让我们先从一维的情况来分析，那么我们先看一维时有两个点A和B的情况,
 * <p>
 * ______A_____P_______B_______
 * <p>
 * 那么我们可以发现，只要开会为位置P在 [A, B] 区间内，不管在哪，距离之和都是A和B之间的距离，如果P不在 [A, B] 之间，那么距离之和就会大于A和B之间的距离，
 * 那么我们现在再加两个点C和D：
 * <p>
 * ______C_____A_____P_______B______D______
 * <p>
 * 我们通过分析可以得出，P点的最佳位置就是在 [A, B] 区间内，这样和四个点的距离之和为AB距离加上 CD 距离，在其他任意一点的距离都会大于这个距离，
 * 那么分析出来了上述规律，这题就变得很容易了，我们只要给位置排好序，然后用最后一个坐标减去第一个坐标，即 CD 距离，倒数第二个坐标减去第二个坐标，
 * 即 AB 距离，以此类推，直到最中间停止，那么一维的情况分析出来了，二维的情况就是两个一维相加即可
 * <p>
 * 为什么work，根据例子的 得出来的I 和 J分别是， 0, 0, 2 和 0, 2, 4
 */

public class BestMeetingPoint {

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for (int i = 0; i < m; i++) {       // 这个是按照行扫的，所以j值不是有序的。需要另外一个loop按照列去得到一个排序的list
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {         //
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }

        return min(I) + min(J);
    }

    private int min(List<Integer> list) {
        int i = 0;
        int j = list.size();
        int sum = 0;
        while (i < j) {
            sum += list.get(j--) - list.get(i);
        }
        return sum;
    }
}
