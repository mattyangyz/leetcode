//package NoTemplate;
//
//import Tree.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UniqueBinarySearchTreesII {
//
//    public static List<TreeNode> generateTrees2(int n) {
//        if (n == 0) {
//            return new ArrayList<>();
//        }
//        return genTreeList(1, n);
//    }
//
//    public static List<TreeNode> genTreeList(int start, int end) {
//        List<TreeNode> list = new ArrayList<>();
//        if (start > end) {
//            list.add(null);
//        }
//        for(int idx = start; idx <= end; idx++){
//            List<TreeNode> leftList = genTreeList(start, idx - 1);
//            List<TreeNode> rightList = genTreeList(start + 1, idx);
//
//            for (TreeNode left : leftList) {
//                for (TreeNode right : rightList) {
//                    TreeNode root = new TreeNode(idx);
//                    root.left = left;
//                    root.right = right;
//                    list.add(root);
//                }
//            }
//        }
//        return list;
//    }
//}
