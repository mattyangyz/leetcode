package Tree.SameSymmetricTree;


import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 在每一层先检查再递归， 所以这是pre-order的思路。
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        Deque<TreeNode> deqP = new ArrayDeque<>();
        Deque<TreeNode> deqQ = new ArrayDeque<>();

        deqP.push(p);
        deqQ.push(q);

        while (!deqP.isEmpty() && !deqQ.isEmpty()) {
            TreeNode pCurr = deqP.pop();
            TreeNode qCurr = deqQ.pop();

            if (pCurr.val != qCurr.val) {
                return false;
            }

            if (pCurr.right == null || qCurr.right == null) {
                if (pCurr.right != null || qCurr.right != null) {
                    return false;
                }
            } else{
                deqP.push(pCurr.right);
                deqQ.push(qCurr.right);
            }

            if (pCurr.left == null || qCurr.left == null) {
                if (pCurr.left != null || qCurr.right != null) {
                    return false;
                }
            } else{
                deqP.push(pCurr.left);
                deqQ.push(pCurr.left);
            }
        }
        return deqP.isEmpty() && deqQ.isEmpty();
    }

}
