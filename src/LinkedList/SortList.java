package LinkedList;


/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * <p>
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * <p>
 * 这是一个bottom up的方法， 先recursive到最底的元素， 然后往上走开始合并。
 */

// https://www.youtube.com/watch?v=ts1Y5zhuuHA
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);                      // 根据的到的middle，把array分成两半
        ListNode secondPart = middle.next;
        middle.next = null;

        ListNode l1 = sortList(head);                           // 这里就是一直走到最底
        ListNode l2 = sortList(secondPart);

        return merge(l1, l2);
    }

    private ListNode getMiddle(ListNode head) {                 // 用两个pointer去走， 得到中间的那个元素。

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {                      // 必须有一个先到达null，然后下一个没到达的
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummy.next;
    }
}
