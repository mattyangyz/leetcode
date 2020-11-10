package LinkedList;


/**
 * Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
 * <p>
 * Start with the head as the current node.
 * Keep the first m nodes starting with the current node.
 * Remove the next n nodes
 * Keep repeating steps 2 and 3 until you reach the end of the list.
 * Return the head of the modified list after removing the mentioned nodes.
 * <p>
 * Follow up question: How can you solve this problem by modifying the list in-place?
 */

// 关键是prev.next = curr就能remove掉n个中间元素，这是关键。
public class DeleteNNodesAfterMNodesOfALinkedList {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode prev;

        while (curr != null) {
            int i = m - 1;  // 考虑到已经在head，所以 -1 即可
            int j = n + 1;  // 考虑到免得prev.next = curr.next 所以直接多走一个。

            while (i > 0 && curr != null) {
                curr = curr.next;
                i--;
            }
            prev = curr;

            while (j > 0 && curr != null) {
                curr = curr.next;
                j--;
            }
            if (prev != null) {
                prev.next = curr;
            }
        }

        return head;

    }
}
