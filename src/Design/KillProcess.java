package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * <p>
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 * <p>
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 * <p>
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 * <p>
 * Example 1:
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 * 3
 * /   \
 * 1     5
 * /
 * 10
 * Kill 5 will also kill 10.
 * Note:
 * The given kill id is guaranteed to be one of the given PIDs.
 * n >= 1.
 * <p>
 * 思路: hashmap + dfs
 */

public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
                list.add(pid.get(i));
                map.put(ppid.get(i), list);
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(kill);
        killHelper(map, ans, kill);
        return ans;
    }

    public void killHelper(HashMap<Integer, List<Integer>> map, List<Integer> ans, int kill) {   // 这里用DFS去做
        if (map.containsKey(kill)) {
            for (int children : map.get(kill)) {
                ans.add(children);
                killHelper(map, ans, children);
            }
        }
    }
}
