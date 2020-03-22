package Tree.PreInPostOrderTraversal;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return dfs(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode dfs(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart + 1 <= preEnd) {
            int lenthOfLeftSubTree = map.get(pre[preStart + 1]) - postStart;
            root.left = dfs(pre, preStart + 1, preStart + lenthOfLeftSubTree + 1,
                    post, postStart, postStart + lenthOfLeftSubTree, map);
            root.right = dfs(pre, preStart + 1 + lenthOfLeftSubTree + 1, preEnd,
                    post, postStart + lenthOfLeftSubTree + 1, postEnd - 1, map);
        }
        return root;
    }
}
