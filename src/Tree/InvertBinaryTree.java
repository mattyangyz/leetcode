package Tree;


import java.util.Stack;

/**
 * 关键要理解 如果一个弄得从左边变换到右边， 他所有的children都会变 所以只需要变换他自己就行，children会在recursive下去的时候被处理
 *
 * 两种做法 一种recursice 一种stack
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    public TreeNode invertTreeWithStack(TreeNode root){
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);

            }

        }
        return root;
    }
}
