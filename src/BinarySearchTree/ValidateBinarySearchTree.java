//package BinarySearchTree;
//
//import Tree.TreeNode;
//
//import java.util.LinkedList;
//
//// TODO: NOT YET
//public class ValidateBinarySearchTree {
//    LinkedList<TreeNode> stack = new LinkedList<>();
//    LinkedList<Integer> uppers = new LinkedList<>();
//    LinkedList<Integer> lowers = new LinkedList<>();
//
//    public void update(TreeNode root, Integer lower, Integer upper) {
//        stack.add(root);
//        lowers.add(lower);
//        uppers.add(upper);
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        Integer lower = null;
//        Integer upper = null;
//        Integer val = null;
//
//        update(root, lower, upper);
//    }
//}
