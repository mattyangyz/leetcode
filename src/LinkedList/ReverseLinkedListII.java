package LinkedList;


/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * <p>
 * https://www.cnblogs.com/grandyang/p/4306611.html
 **/

//  这题有别于reverseLinkedList 需要移动prev curr 或是 next。
//  这题完全不能移动prev 和 curr， 只需要通过操作prev和curr的的next pointer去完成。

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        // dummy -> head
        ListNode dummy = new ListNode(-1); // 这么做是防止只有从index 1开始，这样prev就会是null的情况。
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;


        for (int i = m; i <= n; i++) {

            ListNode next = curr.next; // 看ipad
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}
