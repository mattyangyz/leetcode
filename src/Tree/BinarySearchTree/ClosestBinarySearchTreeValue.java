package Tree.BinarySearchTree;

import Tree.TreeNode;

/**
 * Linkedin
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: 4
 * <p>
 * 思路： 利用普通的BST的特性就行。不需要什么fancy的技巧
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closestVal = root.val;
        while (root != null) {
            // update cloestVal if the current value isf closer to target
            closestVal = (Math.abs(target - root.val) < Math.abs(target - closestVal)) ? root.val : closestVal;
            if (closestVal == target) {
                return closestVal;
            }
            root = root.val > target ? root.left : root.right; //binary search
        }
        return closestVal;
    }


    int closest = 0;

    public int closestValueRecursive(TreeNode root, double target) {
        closest = root.val;
        closest(root, target);
        return closest;
    }

    private void closest(TreeNode root, double target) {

        if (root == null) {
            return;
        }
        if (Math.abs(target - root.val) < Math.abs(target - closest)) {
            closest = root.val;
        }

        if (target < root.val) {
            closest(root.left, target);
        } else {
            closest(root.right, target);
        }
    }
}
