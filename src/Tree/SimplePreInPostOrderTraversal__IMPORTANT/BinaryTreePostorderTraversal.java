package Tree.SimplePreInPostOrderTraversal__IMPORTANT;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import Tree.TreeNode;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode p = root;
        while (stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            }
            else{
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return result;
    }
}
