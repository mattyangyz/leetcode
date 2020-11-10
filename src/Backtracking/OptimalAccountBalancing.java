package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 * <p>
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
 * <p>
 * Note:
 * <p>
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 * Example 1:
 * <p>
 * Input:
 * [[0,1,10], [2,0,5]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 * <p>
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 * Example 2:
 * <p>
 * Input:
 * [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #1 gave person #0 $1.
 * Person #1 gave person #2 $5.
 * Person #2 gave person #0 $5.
 * <p>
 * Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

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
            if (cur * next < 0) {                                   // 一个是给钱，一个是被给钱，这两个符号会相反，得到 < 0 的。
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
