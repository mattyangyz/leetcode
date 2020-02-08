package Tree;


/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
 * <p>
 * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
 * <p>
 * If no such second minimum value exists, output -1 instead.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * Output: 5
 * Explanation: The smallest value is 2, the second smallest value is 5.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 2
 * / \
 * 2   2
 * <p>
 * Output: -1
 * Explanation: The smallest value is 2, but there isn't any second smallest value.
 * <p>
 * 思路： https://www.youtube.com/watch?v=TJdWzpKywHg&t=240s
 * <p>
 * 1. root肯定是最小的， 目标找到一个比root大， 比candidate小的数 这个就是第二个min的数字。
 * 2. 不能一找到一个比root大， 比candidate小的数 就停下来。
 * 3. 必须遍历整科树才行。
 */

public class SecondMinimumNodeInABinaryTree {

    private int candidate = Integer.MAX_VALUE;
    private boolean found = false;

    public int findSecondMinimumValue(TreeNode root) {
        secondMinHelper(root, root.val);

        if (found == false) {
            return -1;
        }
        return candidate;
    }

    private void secondMinHelper(TreeNode root, int val) {
        if (root == null) {
            return;
        }

        if (root.val > val && root.val <= candidate) {
            candidate = root.val;
            found = true;
        }

        secondMinHelper(root.left, val);
        secondMinHelper(root.right, val);
    }
}
