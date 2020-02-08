package BinarySearchTree.InorderSuccessorInBST;

import Tree.TreeNode;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 *
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 *
 * 思路: The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
 * root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res.
 * However, we don't know if there is anymore node on root's left that is larger than p.val.
 * So we move root to its left and check again.
 *
 * root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child.
 * So we only need to consider root's right child, thus we move root to its right and check again.
 *
 * 1. 如果当前的 root 比 target大的话， 说明 这个 root 有可能是结果，然后接着往左边走。
 *
 * 2. 如果当前的 root 比 target 小的话，说明这个不可能是结果 因为根据in order的性质。 这时候就往右边走就行了。
 *
 * 3. 如果当前 root 是等于 target的话， 也是往右边走。因为in order的下一个是在又边。可以结合以上的这2， 3条件。
 */

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor2(root.right, p);
        } else {
            TreeNode res = inorderSuccessor2(root.left, p);
            return res != null ? res : root;
        }
    }
}
