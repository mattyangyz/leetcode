package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, l
 * eaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)
 * <p>
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node.
 * If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary.
 * Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists.
 * If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * <p>
 * 意思： 分三步走。第一步是左边的 不包括leaves node，然后是所有的leaves 最后是右边的 不包括leaves node。但是要记得左边的话，要是有左node的话 就不加右node到结果里面。
 * 要是右边的话 要是有右node的话 就不加左node里面。
 */

public class BoundaryOfBinaryTree {

    List<Integer> res = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return res;
    }

    // only add root node, not leave node 而且 要是没有左边的话 加右边不然的话只加左边
    public void leftBoundary(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        res.add(root.val);
        if (root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);

        }
    }

    public void leaves(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }

    public void rightBoundary(TreeNode root) {  // 基本上跟leftBoundary一样的，就是add要放在后面。
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        if (root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }
        res.add(root.val);
    }


}
