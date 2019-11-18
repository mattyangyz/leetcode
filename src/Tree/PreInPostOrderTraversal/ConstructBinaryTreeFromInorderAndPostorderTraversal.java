package Tree.PreInPostOrderTraversal;

import Tree.TreeNode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return buildTree(inOrder, inOrder.length - 1, 0, postOrder, postOrder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart) {

        if (postStart < 0 || inStart < inEnd) {
            return null;
        }

        // the last element in postorder is the root
        TreeNode root = new TreeNode(postOrder[postStart]);

        int rootIndex = inStart;

        // find the index of the root from inorder. Iterating from the end
        for (int i = inStart; i >= inEnd; i--) {
            if (inorder[i] == postOrder[postStart]) {
                rootIndex = i;
                break;
            }
        }
        //build right and left subtrees. Again, scanning from the end to find the sections.
        root.right = buildTree(inorder, inStart, rootIndex + 1, postOrder, postStart - 1);
        root.left = buildTree(inorder, rootIndex - 1, inEnd, postOrder, postStart - (inStart - rootIndex) - 1);

        return root;
    }
}
