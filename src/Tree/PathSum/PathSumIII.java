package Tree.PathSum;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/discuss/91889/Simple-Java-DFS
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 * 思路: 1)DFS 2)DFS + MEMO 应该用这种做法。 第二种做法的思路是每次走下去的时候kepp一个currSum, 要是currSum - sum在map里面出现过的话 就证明是有path的但是至于path
 * 是什么，我们不care。 注意回溯回来的时候要把curSum拿走 防止 左右path的出现， 因为题目只允许从parent到child的path。
 */


public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int pathImLeading = count(root, sum);           // 自己为开头的路径数
        int leftPathSum = pathSum(root.left, sum);      // 左边路径总数（相信他能算出来）
        int rightPathSum = pathSum(root.right, sum);    // 右边路径总数（相信他能算出来）
        return leftPathSum + rightPathSum + pathImLeading;
    }

    public int count(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        // 我自己能不能独当一面，作为一条单独的路径呢？
        int isMe = (node.val == sum) ? 1 : 0;

        // 左边的小老弟，你那边能凑几个 sum - node.val 呀？
        int leftBrother = count(node.left, sum - node.val);
        // 右边的小老弟，你那边能凑几个 sum - node.val 呀？

        int rightBrother = count(node.right, sum - node.val);

        return  isMe + leftBrother + rightBrother; // 我这能凑这么多个
    }


    public int pathSum2(TreeNode root, int sum) {     // 这种做法更能接受
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int curSum, int sum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0); // 看之前的有没有和是currSum - sum的

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);

        map.put(curSum, map.get(curSum) - 1); // 防止左右path的出现，所以要把这个curSum拿走
        return res;
    }


}



