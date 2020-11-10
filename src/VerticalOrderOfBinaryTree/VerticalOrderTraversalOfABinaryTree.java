package VerticalOrderOfBinaryTree;

import Tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 * <p>
 * 思路: 先根据x为key，把所有的node 归纳到一起。
 * 然后利用comparator根据y去排序放入结果里面。
 */

// 这题的关键在于把每一个treeNode打包成一个包含treeNode以及x y坐标的一个node，然后再从root往下走把每一层的node都放到对应的x坐标map中。
// 首先把root按照一层一层去遍历，同时打包成一个Node class，然后打包的同时计算相应的x和y。然后把这些node根据x的坐标放到一个map中，
// 然后从最小到最大值依次从map中取出来 然后放到结果当中
public class VerticalOrderTraversalOfABinaryTree {

    class Node {
        TreeNode root;
        int x;
        int y;

        public Node(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));

        int minX = 0;
        int maxX = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();                            // 其实这里这个size的for loop有没有都没有关系。
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                map.putIfAbsent(cur.x, new ArrayList<>());
                minX = Math.min(minX, cur.x);
                maxX = Math.max(maxX, cur.x);

                map.get(cur.x).add(cur);

                if (cur.root.left != null) {
                    queue.offer(new Node(cur.root.left, cur.x - 1, cur.y - 1));
                }
                if (cur.root.right != null) {
                    queue.offer(new Node(cur.root.right, cur.x + 1, cur.y - 1));
                }
            }
        }


        for (int i = minX; i <= maxX; i++) {
            Collections.sort(map.get(i), (a, b) -> {
                if (a.y == b.y) {
                    return a.root.val - b.root.val; // 如果坐标相同，则按照数字由大到小排序
                } else {
                    return b.y - a.y;               // 注意这里， 是降序根据y。
                }
            });
            res.add(new ArrayList<>());
            for (Node node : map.get(i)) {
                res.get(res.size() - 1).add(node.root.val);
            }
        }
        return res;


    }
}
