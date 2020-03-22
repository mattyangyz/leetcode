package LevelOrder;


import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * [ 4 5 6 7 1 2 3 ] ，[ 4 5 6 7 ] 和 [ 1 2 3 ] 两段有序。
 *
 * 而对于 [ 1 2 3 4] 这种，可以看做 [ 1 2 3 4 ] 和 [ ] 特殊的两段有序。
 *
 * 而对于我们要找的 target ， target 不在的那一段，所有数字可以看做无穷大，这样整个数组就可以看做有序的了，可以用正常的二分法去找 target 了，例如
 *
 * [ 4 5 6 7 1 2 3] ，如果 target = 5，那么数组可以看做 [ 4 5 6 7 inf inf inf ]。
 *
 * [ 4 5 6 7 1 2 3] ，如果 target = 2，那么数组可以看做 [ -inf -inf - inf -inf 1 2 3]。
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 */

public class SerializeAndDeserializeBinaryTree {

    public String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null ");
                continue;
            }
            sb.append(cur.val + " ");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < str.length; i++) {
            TreeNode cur = queue.poll();
            if (!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if (!str[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

}
