package Tree.LowestCommonAncestor;

import java.util.ArrayList;
import java.util.List;

import Tree.TreeNode;

// https://www.youtube.com/watch?v=VvdlzPAQE0s
public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {

    public static void main(String[] args){
        String t = "";
        test(t);
        System.out.println(t);
    }

    static void test(String test) {
        test = test + "l";
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();

        StringBuilder dir1 = new StringBuilder("");
        StringBuilder dir2 = new StringBuilder("");

        dfs(root, nums1, dir1, startValue);
        dfs(root, nums2, dir2, destValue);

        // nums1: 1 - 3; nums2: 2 - 6
        // dirs1: L-L dirs2: R-L

        int k = 0;
        while(k < nums1.size() && k < nums2.size() && nums1.get(k).equals(nums2.get(k))){
            k++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = k; i < dir1.length(); i++) {
            sb.append("U");
        }
        return sb.append(dir2.substring(k)).toString();
    }

    // 注意这里一定是要用stringbuilder，不能直接传string，请看这里 https://www.programcreek.com/2013/09/string-is-passed-by-reference-in-java/
    private boolean dfs(TreeNode root, List<Integer> nums, StringBuilder str, int target) {
        if(root == null){
            return false;
        }
        if(root.val == target){
            return true;
        }
        if(root.left != null){
            nums.add(root.left.val);
            str = str.append("L");
            if(dfs(root.left, nums, str, target)){      // 找到了就退出，不用做backtracking
                return true;
            }
            nums.remove(nums.size() - 1);
            str.setLength(str.length() - 1);
        }
        if(root.right != null){
            nums.add(root.left.val);
            str = str.append("R");
            if(dfs(root.right, nums, str, target)){     // 找到了就退出，不用做backtracking
                return true;
            }
            nums.remove(nums.size() - 1);
            str.setLength(str.length() - 1);
        }
        return false;
    }
}
