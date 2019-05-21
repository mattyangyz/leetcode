package Tree.Preorder;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 */

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null){
            searchBT(root, "", result);
        }
        return result;
    }

    private void searchBT(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
        }
        if (root.left != null) {
            searchBT(root.left, path + root.val + "->", ans);
        }
        if (root.right != null) {
            searchBT(root.right, path + root.val + "->", ans);
        }
    }
}
