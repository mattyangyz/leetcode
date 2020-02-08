package LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * <p>
 * <p>
 * 思路: 如果有长的那一部分，那么一开始长的那一部分肯定不是结果。因为intesection是从后面开始的，而且到结束， 所以可以skip掉。
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int lenA = len(headA);
        int lenB = len(headB);

        if (lenA > lenB) {
            while (lenA != lenB) {      // skip长的那一部分
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    // 求长度。
    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
