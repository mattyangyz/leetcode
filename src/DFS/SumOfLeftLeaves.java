package DFS;

import Tree.TreeNode;


/**
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * <p>
 * 思路: DFS. 学会去用root.left.left and root.left.right去预判断是否为leave。
 * 预判断是只在leave上一层的时候就进行判断，不能等到当前到了leaves root.left root.right这样去判断
 */


public class SumOfLeftLeaves {

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeavesHelper(root);
    }


    public int sumOfLeftLeavesHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {          // 这里保证只有left的会被考虑，而right不会被考虑。
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                sumOfLeftLeaves(root.left);
            }
        }
        sumOfLeftLeaves(root.right);
        return res;
    }

}
