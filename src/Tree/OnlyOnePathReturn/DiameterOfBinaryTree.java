package Tree.OnlyOnePathReturn;

import Tree.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */


public class DiameterOfBinaryTree {

    private int diameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        goingDown(root);
        return diameter;
    }

    private int goingDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = goingDown(root.left);
        int rightSum = goingDown(root.right);

        diameter = Math.max(diameter, leftSum + rightSum);     // 这个跟下面的return结合起来就能同时算一边和两边了

        return Math.max(leftSum, rightSum) + 1;                 // 只取一边
    }
}
