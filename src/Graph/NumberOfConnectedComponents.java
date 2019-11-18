package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Linkedin
 * <p>
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77583/Java-Union-find-and-DFS-and-BFS-Code-(very-clean)
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * <p>
 * 思路：跟graph valid tree是相似的 一开始把edges转换成adjList的时候。
 * 1. 把edges转换成adjList
 * 2. 对于每个node，走遍它的邻居，并且要mark visited。
 * 3. 用DFS去完成
 */

public class NumberOfConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {              // 因为需要历遍所有的node， 所有这里是 需要一个loop
            if (!visited[i]) {
                count++;
                for (int neighbor : graph.get(i)) {
                    dfs(neighbor, visited, graph);
                }
            }

        }
        return count;
    }


    private void dfs(int node, boolean[] visited, List<List<Integer>> graph) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int neighbor : graph.get(node)) {        // 对于每一个node 这是找他们的邻居
            dfs(neighbor, visited, graph);
        }
    }

}
