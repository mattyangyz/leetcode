package Graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Linkedin TODO: Need to go over AGAIN.
 * <p>
 * An undirected graph is tree if it has following properties.
 * 1) There is no cycle. 1, 如果对于一个node V， 如果有一个U是已经visited的 但U不是V的parent， 那么这就是有cycle。
 * 2) The graph is connected. 2， 如果每一个vertex都是reachable，那么这么graph就是reachable的
 * <p>
 * How to detect cycle in an undirected graph?
 * We can either use BFS or DFS. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is not parent of v,
 * then there is a cycle in graph. If we don’t find such an adjacent for any vertex,
 * we say that there is no cycle (See Detect cycle in an undirected graph for more details).
 * <p>
 * How to check for connectivity?
 * Since the graph is undirected, we can start BFS or DFS from any vertex and check if all vertices are reachable or not.
 * If all vertices are reachable, then graph is connected, otherwise not.
 * <p>
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 * <p>
 * 思路，
 * 1. 先建立一个adj list去存所有对应的关系
 * 2. 选0开始，遍历0所有的邻居。 把邻居加入到stack中，并且把邻居连到0的edge去除。
 * 3. 一旦遇到有的邻居已经是visited过得，那么久存在环。
 * 4.
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) { // 这种写法必须用set
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];


        // no cycle
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (visited[node]) {
                return false;
            }
            visited[node] = true;
            for (Integer neighbor : adjList.get(node)) {
                stack.push(neighbor);
                adjList.get(neighbor).remove(node);
            }
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean validTreeRecursive(int n, int[][] edges) { // 这种写法必须用set
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        // no cycle
        if (!hasCycle(adjList, 0, visited, -1)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int u, boolean[] visited, int p) {
        visited[u] = true;

        for (int i = 0; i < graph.get(u).size(); i++) {
            int neighbor = graph.get(u).get(i);
            if (neighbor == p) {
                continue;
            }
            if (visited[neighbor] || !hasCycle(graph, neighbor, visited, u)) {
                return false;
            }
        }
        return true;
    }
}
