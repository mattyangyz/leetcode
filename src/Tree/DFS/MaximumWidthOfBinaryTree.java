package Tree.DFS;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * <p>
 * 思路: dfs 遍历， 然后第一次遇见leftmost的时候把它加进start里面。 如果不是leftmost了，就update end的index。
 * start 和 end里面存的实际上是indexWe know that a binary tree can be represented by an array
 * (assume the root begins from the position with index 1 in the array).
 * If the index of a node is i, the indices of its two children are 2*i and 2*i + 1.
 * The idea is to use two arrays (start[] and end[]) to record the the indices of the leftmost
 * node and rightmost node in each level, respectively.
 * For each level of the tree, the width is end[level] - start[level] + 1.
 * Then, we just need to find the maximum width.
 */

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1, new ArrayList<Integer>(), new ArrayList<>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() < level) {                    // todo: 关键要理解这里， 这是没当开始新的一层的时候吧leftmost加到start和end中
            start.add(order);
            end.add(order);
        } else {                                           // todo: 这是 以后再visit这一层的情况时候(不是leftmost)，把这个index加到end中
            end.set(level - 1, order);
        }

        int cur = end.get(level - 1) - start.get(level - 1) + 1;

        int left = dfs(root.left, level + 1, order * 2, start, end);
        int right = dfs(root.right, level + 1, order * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
