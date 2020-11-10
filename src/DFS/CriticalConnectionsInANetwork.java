package DFS;

import java.util.*;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * <p>
 * 思路: 就是找环，环上任意的一条边都不会是critical connect。从root开始， 然后用DFS去遍历， 只要遇到环的话 当前的node的时间就要用min去更新。
 * 如果backtracking回来，邻居的time还是比当前node的时间要大的话 说明没有环 这当前的就是结果。
 */

public class CriticalConnectionsInANetwork {

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(v);
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(v).add(u);
        }

        int timer = 0;
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] timeStampAtThatNode = new int[n];
        criticalConnectionsHelper(graph, -1, 0, timer, visited, result, timeStampAtThatNode);
        return result;
    }

    public void criticalConnectionsHelper(Map<Integer, List<Integer>> map, int parent, int node,
                                          int timer, boolean[] visited, List<List<Integer>> result, int[] timeStamps) {

        visited[node] = true;
        timeStamps[node] = timer++;
        int currentTimeStamp = timeStamps[node];

        for (int neigh : map.keySet()) {
            if (neigh == parent) {
                continue;
            }
            if (!visited[neigh]) {
                criticalConnectionsHelper(map, node, neigh, timer, visited, result, timeStamps);
            }
            // // 这里是关键， 如果遇到环的话，这个timeStamps[node]就会被更新成min 然后会一直被带上去parent那里
            timeStamps[node] = Math.min(timeStamps[neigh], timeStamps[node]);
            if (currentTimeStamp < timeStamps[neigh]) {
                result.add(Arrays.asList(node, neigh));
            }
        }

    }
}
