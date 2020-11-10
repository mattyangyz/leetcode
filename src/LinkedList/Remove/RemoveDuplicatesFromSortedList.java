package LinkedList.Remove;

import LinkedList.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * <p>
 * 思路: 一个pointer就够了, 千万要注意iterator只有在不相等的时候才move to next。一定不能放在else外面
 */

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode iterator = head;
        while (iterator != null && iterator.next != null) {
            if (iterator.val == iterator.next.val) {
                iterator.next = iterator.next.next;
            } else {
                iterator = iterator.next;
            }
        }
        return head;
    }
}
