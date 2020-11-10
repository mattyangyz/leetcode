package Tree.OnlyOnePathReturn;


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

// 这题的难点在于怎么处理横跨root以及左节点 右节点为最大max，但返回的时候只能返回一边而不是两边
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        goingDown(root);
        return max;
    }

    private int goingDown(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = goingDown(root.left);
        int rightSum = goingDown(root.right);

        int optimizeLeftSum = leftSum > 0 ? leftSum : 0;
        int optimizeRightSum = rightSum > 0 ? rightSum : 0;

        max = Math.max(max, optimizeLeftSum + optimizeRightSum + root.val);     // 这个跟下面的return结合起来就能同时算一边和两边了

        return Math.max(optimizeLeftSum, optimizeRightSum) + root.val;          // 只取一边


    }
}
