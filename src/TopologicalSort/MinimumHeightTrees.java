package TopologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        int[] indegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            if(!map.containsKey(edge[0])){
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])){
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < n; i++) {
                int nodeWithOneInDegree = queue.poll();
                list.add(nodeWithOneInDegree);

                for (int nei : map.getOrDefault(nodeWithOneInDegree, new ArrayList<>())) {
                    indegree[nei]--;
                    if(indegree[nei] == 1){
                        queue.offer(nei);
                    }
                }
            }
            res = list;
        }
        return res;
    }
}
