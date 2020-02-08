package BinarySearchTree;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Linkedin (TODO: FOLLOWING UP and O(logN) solution)
 * <p>
 * Use in order traversal.
 * <p>
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 * <p>
 * <p>
 * 思路：使用in order traversal， 因为in order traversal BST 出来的是由小到大的。 同时使用一个list保存每个traverse的数字， 接下来通过
 * 对比的方式去把数字remove。重点知道什么跟什么比较，已经符合条件后移除的是哪一个
 */

public class ClosestBinarySearchTreeValueII {

    public List<Integer> closestKValue(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }

        helper(res, root.left, target, k);
        if (res.size() == k) {
            //因为inorder的数都是递增的 而且list里面第二个数会比第一个更接近target。只要遇到现在的target - root > target - getfirst
            //的， 就说明以后的值都会比这个root大， 所以直接返回的就行。
            if (Math.abs(target - root.val) < Math.abs(target - res.getFirst())) {        // 必须跟第一个比较
                res.removeFirst();                                                      // 必须移除第一个 有点像queue
            } else {
                return;
            }

        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }
}
