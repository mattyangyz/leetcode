package BinarySearchTree;

import Tree.TreeNode;


/**
 * 难， 必须要画图去理解。
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * <p>
 * <p>
 * 思路: inorder的话，是一个递增数列。这里下面做的只是compare currentnode with its previous node in the "in order tracersal"。
 * <p>
 * The first element is always larger than its next one while the second element is always smaller than its previous one.
 * 第一个element永远大于它的下一个（parent element）， 而且第二个element 永远小于他们previous element。把inorder的排序写出来就知道了
 */

public class RecoverBinarySearchTree {

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null && first == null && prev.val >= root.val) {
            first = prev;
        }
        if (prev != null && first != null && prev.val >= root.val) {
            second = root;
        }

        prev = root;
        helper(root.right);
    }
}
