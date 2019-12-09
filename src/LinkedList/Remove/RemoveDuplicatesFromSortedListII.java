package LinkedList.Remove;

import LinkedList.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 0->1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDeuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;                                 // 这里是因为为了去掉第一个例子里面的一所以把这个p设成dummy而不是head

        while (previous.next != null && previous.next.next != null) {
            if (previous.next.val == previous.next.next.val) {
                int sameNumber = previous.next.val;
                while (previous.next != null && previous.next.val == sameNumber) {
                    previous.next = previous.next.next;                   // 删除是这里发生
                }
            } else {
                previous = previous.next;
            }
        }
        return dummy.next;
    }
}
