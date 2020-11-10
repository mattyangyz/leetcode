package BinarySearchTree.ConvertToBinarySearchTree;


import LinkedList.ListNode;
import Tree.TreeNode;

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

// 先统计有size是多少，然后用类似二分法去求出. 然后用一个DFS的方法不断先放左边，
// 然后右边，但是要注意怎么从input head里面得到node的相应的value，是通过curr = curr.next得到的
public class ConvertSortedListToBinarySearchTree {

    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode runner = head;
        curr = head;
        while (runner != null) {
            runner = runner.next;
            size++;
        }
        return recursiveHelper(0, size - 1);
    }

    public TreeNode recursiveHelper(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = recursiveHelper(start, mid - 1);

        TreeNode currNode = new TreeNode(curr.val);
        currNode.left = left;
        curr = curr.next;                                   // 注意这里是关键

        TreeNode right = recursiveHelper(mid + 1, end);
        currNode.right = right;

        return currNode;
    }
}
