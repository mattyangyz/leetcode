package Tree;


import LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 *
 *Cuz it's depth first search. The first time the program reaches "node = node.next" will be when the program call inorderHelper(start, mid - 1)
 * for the left most node. We insert the first element of linked list to the left most node. And then we do "node = node.next",
 * we have the second element ready, which will be assigned to the parent node of left most node. And then node = node.next happens again,
 * the third element is ready for the parent node's right node. Try an easy example of 3 nodes tree you might understand
 *
 *
 */

public class ConvertSortedListToBinarySearchTree {

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while (runner != null) {
            size++;
            runner = runner.next;
        }

        return inOrderHelper(0, size - 1);
    }

    private TreeNode inOrderHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inOrderHelper(0, mid - 1);

        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left = left;
        node = node.next;

        TreeNode right = inOrderHelper(mid + 1, end);
        treeNode.right = right;

        return treeNode;
    }
}
