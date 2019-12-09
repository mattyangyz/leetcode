package BinarySearchTree;

import Tree.TreeNode;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * <p>
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * The successor of a node p is the node with the smallest key greater than p.val.
 * <p>
 * <p>
 * 思路: The idea is to compare root's value with p's value if root is not null, and consider the following two cases:
 * <p>
 * root.val > p.val. In this case, root can be a possible answer, so we store the root node first and call it res. However, we don't know if there is anymore node on root's left that is larger than p.val. So we move root to its left and check again.
 * <p>
 * root.val <= p.val. In this case, root cannot be p's inorder successor, neither can root's left child. So we only need to consider root's right child, thus we move root to its right and check again.
 * <p>
 * We continuously move root until exhausted. To this point, we only need to return the res in case 1.
 */

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val <= p.val) {          // 右边的话，那么当前root就不会是result的candidate。 因为这是inorder
                root = root.right;
            } else {                           // 左边的话，那么当前root也有可能是candidate
                result = root;
                root = root.left;
            }
        }
        return result;
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
