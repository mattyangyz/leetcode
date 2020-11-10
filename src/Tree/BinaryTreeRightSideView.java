package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        goingDown(root, 0, list);
        return list;
    }

    public void goingDown(TreeNode root, int count, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (count == list.size()) {
            list.add(root.val);
        }
        goingDown(root.right, count + 1, list);
        goingDown(root.left, count + 1, list);
    }
}
