package Tree.Ancestor;

import Tree.TreeNode;

/**
 * Linkedin
 * <p>
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as
 * descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 思路: 这一题的关键是怎么判断parent 就是common ancestor的情况。由上往下走的时候要是root match任何一个的情况下，这就是这种情况。
 * 否则就走左边看，然后走右边看。
 */

public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestorHelper(root, p, q);
    }


    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestorHelper(root.left, p, q);
        TreeNode right = lowestCommonAncestorHelper(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
