package Tree.PostOrder;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * <p>
 * Two trees are duplicate if they have the same structure with same node values.
 * <p>
 * Example 1:
 * <p>
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   2   4
 * /
 * 4
 * The following are two duplicate subtrees:
 * <p>
 * 2
 * /
 * 4
 * and
 * <p>
 * 4
 * Therefore, you need to return above trees' root in the form of a list.
 * <p>
 * 思路: 就是用postorder去解决， 加一个hashmap。
 */


public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode curr, Map<String, Integer> map, List<TreeNode> res) {
        if (curr == null) {
            return "#";
        }
        String serial = curr.val + postorder(curr.left, map, res) + "_" + postorder(curr.right, map, res);
        if (map.getOrDefault(serial, 0) == 1) {
            res.add(curr);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
