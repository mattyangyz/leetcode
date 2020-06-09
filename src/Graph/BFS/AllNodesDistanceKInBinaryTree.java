package Graph.BFS;

import Tree.TreeNode;

import java.util.*;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * <p>
 * Output: [7,4,1]
 * <p>
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * <p>
 * <p>
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 * <p>
 * 思路: 把树变换成图，然后从target出发，用queue进行一个bfs。注意需要用一个visited来记录走过的邻居，不然会导致重复的出现。
 */

public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 构建图 然后遍历图 -> k = 0 结果统计输出
        List<Integer> res = new ArrayList<>();
        if (k < 0) {
            return res;
        }
        buildGraph(root, null);

        Set<TreeNode> visited = new HashSet<>();            // 防止再走回原来的路线
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            // 同一批次一起处理
            int size = queue.size();
            if (k == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    res.add(cur.val);
                }
                return res;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                for (TreeNode nei : map.get(cur)) {
                    if (visited.contains(nei)) {
                        continue;
                    }
                    queue.offer(nei);
                    visited.add(nei);

                }
            }
            k--;
        }
        return res;
    }

    private void buildGraph(TreeNode node, TreeNode parent) {    // 构建图
        if (node == null) {
            return;
        }
        // 保证当前的node没有被放到map里面
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildGraph(node.left, node);
            buildGraph(node.right, node);
        }
    }
}
