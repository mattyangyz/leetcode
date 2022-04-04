package Tree;

/**
 * 116. Populating Next Right Pointers in Each Node
 * Medium
 * <p>
 * 1323
 * <p>
 * 129
 * <p>
 * Favorite
 * <p>
 * Share
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * 思路: 用递归 一层一层去走，两种情况 第一种handle左子到右子的情况， 第二种handle当前root的右边指向邻居左边的情况。
 * <p>
 * 图在这里: https://www.cnblogs.com/grandyang/p/4288151.html
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {            // 这是root是最上面的情况，
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;                   // 因为是perfect 所以只要上面的root.right有的话， 这个root.next.left必须得有
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
