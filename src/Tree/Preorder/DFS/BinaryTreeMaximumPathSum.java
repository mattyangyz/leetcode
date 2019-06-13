package Tree.Preorder.DFS;


import Tree.TreeNode;

/**
 * 需要一个global variable. 一直走到最低。 把curr的左边跟0对比，把curr的右边跟0比， 然后把curr
 * 的值跟左边右边的值加一起跟max比，然后结果跟maxSum比。 最后返回其中一边 不能左右的sum都返回
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int binaryTreeMaximumPathSum(TreeNode root) {

        sumHelper(root);
        return maxSum;
    }

    public int sumHelper(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(sumHelper(root.left), 0);
        int rightSum = Math.max(sumHelper(root.right), 0);

        if (leftSum + rightSum + root.val > maxSum) {
            maxSum = leftSum + rightSum + root.val;
        }

        return Math.max(leftSum, rightSum) + root.val;
    }
}
