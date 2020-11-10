package VerticalOrderOfBinaryTree;

import Tree.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * *   |     *
 * -2, -1, 0, 1, 2, 3 整体的shift右边， -1的index就变成0了，2的index就变成3了。
 * <p>
 * Output:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Examples 2:
 * <p>
 * Input: [3,9,8,4,0,1,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Examples 3:
 * <p>
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 * <p>
 * 思路: 跟VerticalOrderTraversalOfABinary一模一样，除了不需要排序以外。
 */

public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
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


        for (int i = minX; i <= maxX; i++) {                    // 唯一的区别就是少了这里的排序
            res.add(new ArrayList<>());
            for (Node node : map.get(i)) {
                res.get(res.size() - 1).add(node.root.val);
            }
        }
        return res;
    }

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
}
