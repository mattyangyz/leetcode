package BinarySearchTree;

import Tree.TreeNode;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * <p>
 * 思路： 当BST， 要是用inorder traversal的话就是order顺序.
 */

public class KthSmallestElementInABST {

    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        int res = 0;
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, int res) {                // 这里用in order

        if (root == null) {
            return;
        }
        helper(root.left, res);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right, res);
    }

    public int kthSmallestWithStack(TreeNode root, int k) {     // 要一个while 考虑纯左边的情况，另一个考虑每一个左node的右边情况
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) {
                return node.val;
            }
            TreeNode right = node.right;
            while (right != null) {                     // 处理右边有左children的情况
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}
