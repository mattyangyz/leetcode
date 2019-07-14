package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        travel(root, ans, 0);
        return ans;
    }

    private void travel(TreeNode curr, List<List<Integer>> ans, int level) {

        if (curr == null) {
            return;
        }

        if (ans.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            ans.add(newLevel);
        }

        List<Integer> collection = ans.get(level);
        if (level % 2 == 0) {
            collection.add(curr.val);
        }
        else{
            collection.add(0, curr.val);
        }

        travel(curr.left, ans, level + 1);
        travel(curr.right, ans, level + 1);
    }
}
