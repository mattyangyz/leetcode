package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Linkedin
 * <p>
 * 这题的重点在于buttom up.
 * 把height相同的node group起来， 加到同一个index里面， index对应的就是tree的height。
 * <p>
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 * repeat until the tree is empty.
 * <p>
 * Example:
 * Input: [1,2,3,4,5]
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Output: [[4,5,3],[2],[1]]
 * Explanation:
 * <p>
 * 1. Removing the leaves [4,5,3] would result in this tree:
 * <p>
 * 1
 * /
 * 2
 * 2. Now removing the leaf [2] would result in this tree:
 * <p>
 * 1
 * 3. Now removing the leaf [1] would result in the empty tree:
 * <p>
 * []
 */
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        heigh(root, ans);
        return ans;
    }


    private int heigh(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return -1;
        }

        int level = 1 + Math.max(heigh(node.left, res), heigh(node.right, res));
        node.left = null;
        node.right = null;
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        return level;
    }
}
