package Tree;


/**
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling
 * (a left node that shares the same parent node) or empty,
 * flip it upside down and turn it into a tree where the original
 * right nodes turned into left leaf nodes. Return the new root.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,4,5]
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 * <p>
 * <p>
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/163716/Thinking-Process-(Java-Scala)
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution
 * <p>
 * 例子1
 * 4    1
 * / \  / \
 * 5  2    3
 * / \
 * null null
 */

public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {

        if (root == null || root.left == null || root.right == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;     // here cannot be newRoot.left and newRoot.right,
        root.left.right = root;          // since we are returning the newRoot
        // which will always be the left most node.
        // You can not modify it multiple times.
        root.left = null;                // 即使这里设成了null， 当我们返回到root的parent的
        root.right = null;               // 时候，我们依然可以通过他parent的left来得到当前root.left
        // 请参考例子1

        return newRoot;
    }
}
