package BinarySearchTree;

import Tree.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return bstHelper(root, null, null);
    }

    boolean bstHelper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return bstHelper(root.left, min, root.val) && bstHelper(root.right, root.val, max);
    }
}
