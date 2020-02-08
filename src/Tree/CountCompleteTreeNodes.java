package Tree;


/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Note:
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Example:
 * <p>
 * Input:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 * <p>
 * Output: 6
 * <p>
 * 思路： 求出左边和右边的深度，不停地左边和右边地去计算，因为已知一定是一个complate tree，所以可以不停地像右边去
 * 递归下去求出高度。如果相等的话 就直接是2^H - 1。这里要注意的是2^H 是怎么做到的。在binary里面有多少个0就代表是多少的次方
 * 如果是 1000， 就是先得到1 然后往左边shift三位得到1000这就是2^3也就是8.
 * 这题其实跟普通的数node没什么区别，唯一不同就是要确定左边跟右边是不是一样，如果一样就shift得到2^h-1而已。没什么特别难的地方。
 */

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int left = helper(root, true);
        int right = helper(root, false);

        if (left == right) {
            // 有多少个0就代表有多少的次方 比如 10 000 000 就代表2的7次方
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        return isLeft ? helper(root.left, isLeft) + 1 : helper(root.right, isLeft) + 1;
    }
}
