package BinarySearchTree;

import Tree.TreeNode;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 * <p>
 * The binary search tree is guaranteed to have unique values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 * <p>
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 * <p>
 * 思路: 提议就是把bst里面在L跟R 这个range里面的node都加起来。我们可以利用BST的性质去做一些优化。属于简单题。
 */

public class RangeSumOfBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }

    public void helper(TreeNode root, int L, int R) {
        if (root == null) {
            return;
        }

        if (root.val <= R && root.val >= L) {
            sum += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        } else if (root.val < L) {  // 利用了BST的特性优化
            helper(root.right, L, R);
        } else {                       // 利用了BST的特性优化
            helper(root.left, L, R);
        }
    }
}
