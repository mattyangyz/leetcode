package Tree.PostOrder;


import Tree.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * <p>
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * Example :
 * <p>
 * Input:  root = [5,1,5,5,5,null,5]
 * <p>
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * <p>
 * Output: 4
 * <p>
 * 思路: 这题用的是post order遍历，想想用preorder 跟 inorder的话，其实都不太好，因为遍历node的顺序不是我们想要的。
 * 但是postorder的话，就是遍历完左右再到root，这就符合题意了。
 */

public class CountUnivalueSubtrees {

    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    public boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left & right) {                                           // 这里就是post order
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }
}
