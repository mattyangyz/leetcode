package LinkedList;

/**
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

// iterative的话需要三个var，但是recursive的话只需要两个就够了 curr 和 prev。
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode node) {
        return recursive(node, null);
    }

    public ListNode recursive(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
        ListNode newHead = head.next;
        head.next = prev;
        return recursive(newHead, head);
    }
}
