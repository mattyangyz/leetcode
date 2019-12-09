package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.
 * <p>
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.
 * <p>
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * <p>
 * 思路： 最简单的DFS， 但有一些不一样。
 * <p>
 * 这道题给了我们一个无回路有向图，包含N个结点，然后让我们找出所有可能的从结点0到结点N-1的路径。
 * 这个图的数据是通过一个类似邻接链表的二维数组给的，最开始的时候博主没看懂输入数据的意思，
 * 其实很简单，我们来看例子中的input，[[1,2], [3], [3], []]，这是一个二维数组，最外层的数组里面有四个小数组，
 * 每个小数组其实就是和当前结点相通的邻结点，由于是有向图，所以只能是当前结点到邻结点，反过来不一定行。
 * 那么结点0的邻结点就是结点1和2，结点1的邻结点就是结点3，结点2的邻结点也是3，结点3没有邻结点。
 * 那么其实这道题的本质就是遍历邻接链表，由于要列出所有路径情况，那么递归就是不二之选了。
 * 我们用cur来表示当前遍历到的结点，初始化为0，然后在递归函数中，先将其加入路径path，如果cur等于N-1了，
 * 那么说明到达结点N-1了，将path加入结果res。否则我们再遍历cur的邻接结点，调用递归函数即可，参见代码如下：
 */

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);
        return res;
    }

    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(nextNode);
        }
    }
}
