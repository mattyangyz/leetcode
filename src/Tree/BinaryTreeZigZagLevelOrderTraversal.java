package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 思路: 没到新的一层就init一个新的array，关键是基数的时候要add(0, val)。
 */

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        travel(root, ans, 0);
        return ans;
    }

    private void travel(TreeNode curr, List<List<Integer>> ans, int level) {

        if (curr == null) {
            return;
        }

        if (ans.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            ans.add(newLevel);
        }

        List<Integer> collection = ans.get(level);
        if (level % 2 == 0) {
            collection.add(curr.val);
        } else{
            collection.add(0, curr.val);
        }

        travel(curr.left, ans, level + 1);
        travel(curr.right, ans, level + 1);
    }
}
