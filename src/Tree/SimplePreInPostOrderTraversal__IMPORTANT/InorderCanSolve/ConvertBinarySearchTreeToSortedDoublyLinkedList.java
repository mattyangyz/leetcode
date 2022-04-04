package Tree.SimplePreInPostOrderTraversal__IMPORTANT.InorderCanSolve;


/**
 * 思路: 用inorder去遍历这个tree, 边进行inorder traversal边去进行construct list，
 * 根据遍历到的root去设置相应的pointer，prev pointer是必须的。 一开始用dummy只想
 * <p>
 *   4
 * 2   5  ->   1->2->3->4->5
 * 1  3          一开始prev = dummy, 进入到1的时候prev.right = root 实际就是dummy.right = 1 所以 dummy.right 一直指向1
 *              而1的left一直指向dummy。
 *              到最后首尾相连的时候 需要用到这个dummy的right也就是1。 最后1的left要等于5，5的right要等于1
 * <p>
 * 时间 O(N)
 * 空间 O(H)
 */

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    Node prev = null;

    public Node treeToDoublyList(Node root) {

        if (root == null) {
            return null;
        }

        Node dummy = new Node(0, null, null);
        prev = dummy;

        helper(root);
        prev.right = dummy.right;       // 根据例子 最后1的left要等于5，5的right要等于1，这两部去完成。
        dummy.right.left = prev;
        return dummy.right;             // dummy永远指向最左边的元素也就是1.

    }

    public void helper(Node root) {        // 这里利用到inorder
        if (root == null) {
            return;
        }
        helper(root.left);
        root.left = prev;                  //     2
        prev.right = root;                 //  1     3
        prev = root;                       // 想想上面的例子2的left要设成prev, prev的right要设成2，然后update prev
        helper(root.right);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {

        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
