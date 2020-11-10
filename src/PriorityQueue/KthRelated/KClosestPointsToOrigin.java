package PriorityQueue.KthRelated;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 *
 * 注意: 以下的comparator 是一个降序的，因为跟 a b 的input 顺序反了。
 * 一个点到原点的距离 是 sqrt(x^2 + y^2) 但是这个sqrt其实可以省略的 当做比较的时候。
 */

// 关键点是要想清楚用max还是min queue，然后怎么控制queue的数量。
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        if (points == null || points.length == 0 || points[0].length == 0) {
            return res;
        }

        // comparator 第一部分是a2到原点的距离，第二部分是a1到原点的距离
        // 这是一个max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - (b[0] * b[0] + b[1] * b[1]));

        for (int[] p : points) {
            pq.offer(p);         // 必须先放再去check
            if (pq.size() > k) { // 如果size已经超了，就poll出来
                pq.poll();
            }
        }

        int i = 0;
        while (i < k && !pq.isEmpty()) {
            res[i] = pq.poll();
            k++;
        }
        return res;
    }
}
