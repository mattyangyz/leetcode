package Array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Linkedin TODO:NOT YET
 * <p>
 * <p>
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.
 * <p>
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {

        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (visited[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(i);
            visited[i] = 1;
            while (!queue.isEmpty()) {
                int curr = queue.poll();

                for (int neighbor : graph[curr]) {
                    if (visited[neighbor] == 0) {
                        visited[neighbor] = -visited[curr];
                        queue.offer(neighbor);
                    } else if (visited[neighbor] != -visited[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
