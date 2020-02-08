package BinarySearchTree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 重要性没有 SerializeAndDeserializeBT 重要
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 * <p>
 * <p>
 * 思路: preorder： 根节点 现出来然后左节点 然后右节点。用queue去实现分离左节点和右节点。 必须要在serialize的时候得到preorder的string。
 */

public class SerializeAndDeserializeBST {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();        // preorder traversal
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.append(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return res.toString();

    }

    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] str = data.split(" ");
        Queue<Integer> queeu = new LinkedList<>();

        for (String s : str) {
            queeu.offer(Integer.parseInt(s));
        }
        return getNode(queeu);
    }

    public TreeNode getNode(Queue<Integer> queue) {             // preorder的性质，第一个一定是root 然后左边一些 然后右边一些
        if (queue.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallerQ = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < root.val) {   // 分离
            smallerQ.offer((queue.poll()));
        }

        root.left = getNode(smallerQ);                          // 区分开左边小的
        root.right = getNode(queue);                            // 剩下queue里边的都是root的右边的
        return root;
    }
}
