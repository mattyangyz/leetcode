package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 需要更深的理解，还没理解到
public class OptimalAccountBalancing {

    public static void main(String[] args) {

        OptimalAccountBalancing.minTransfers(new int[][]{{0, 1, 10}, {2, 0, 5}});
    }


    public static int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }

        List<Integer> list = new ArrayList();
        for (int v : map.values()) {
            if (v != 0) {
                list.add(v);
            }
        }

        return dfs(0, list);
    }

    private static int dfs(int k, List<Integer> list) {
        if (k == list.size()) return 0;
        int cur = list.get(k);
        if (cur == 0) {
            return dfs(k + 1, list);
        }

        int min = Integer.MAX_VALUE;
        for (int i = k + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (cur * next < 0) {
                list.set(i, cur + next);
                min = Math.min(min, 1 + dfs(k + 1, list));
                list.set(i, next);

                // 这个是优化，为什么要做完才优化呢，是因为cur+next=0是一个我们想要的结果
                // 我们当然要让它进去dfs里面这样的话 就能减少min的次数。
                if (cur + next == 0) break;
            }
        }

        return min;
    }
}
