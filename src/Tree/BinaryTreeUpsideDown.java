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
 *
 *    1
 *   / \
 *  2   3
 * / \
 *4  5
 *
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 *
 *   4
 *  / \
 * 5   2
 *    / \
 *   3  1
 *
 *
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/163716/Thinking-Process-(Java-Scala)
 * https://leetcode.com/problems/binary-tree-upside-down/discuss/49412/Clean-Java-solution
 *
 * 例子1
 *  4    1
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

        // 因为我们返回newRoot给上一层，所以不能直接newRoot.left 这样子去改，那样的话 每一层的recursive call都会modify 这个newRoot.
        root.left.left = root.right;     // here cannot be newRoot.left and newRoot.right,
        root.left.right = root;          // since we are returning the newRoot

        // which will always be the left most node.
        // You can not modify it multiple times.
        root.left = null;                // 原来的root会变成新的right node。根据提议all the right nodes are either leaf nodes with a sibling or
        root.right = null;               // empty, 所以原来的right node下面不会有任何东西， 所以可以直接把这里的left 和 right都set成null
        // 请参考例子1

        return newRoot;
    }
}
