package TopologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]   0 -> 1 想要修1的话必须先修0， 所以[0]的入度++；
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should
 * also have finished course 1. So it is impossible.
 * <p>
 * <p>
 * 0 -》 1 -》 2        修2的话必须先修1， 修1的话必须先修0
 * /
 * 3 -》 4         修4的话必须先修3， 修4的话必须先修2
 * 入度
 * <p>
 * 0 0
 * 1 1
 * 2 1
 * 3 0
 * 4 2
 */

//BFS
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] pre) {
        int[] inDegree = new int[numCourses];
        int res = numCourses;

        for (int[] pair : pre) {                        // 建立indegree的array
            inDegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {     // 把木有indegree的加入到queue中
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int prev = queue.poll();
            res--;                      //这门课已经用过了
            for (int[] pair : pre) {
                if (pair[1] == prev) {
                    inDegree[pair[0]]--;    // 把符合条件的定点从图中去掉, 这里是重点。
                    if (inDegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
