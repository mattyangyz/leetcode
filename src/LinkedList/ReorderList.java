package LinkedList;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * Example 1:
 * <p>
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 * <p>
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * <p>
 * 思路: 先进行找到中点然后进行一个merge。
 */

// 先用一个fast slow pointer找到中间的element。 如果是 1 2 3 4找到2， 如果是 1 2 3 4 5找到3.
// 然后把中间往后的element给reversele，然后中间element的next设置为null
// 最后进行一个merge，merge的时候好好走一遍就能理解了 没有什么特别复杂的。
public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);

        ListNode two = new ListNode(3);

        ListNode three = new ListNode(4);


        head.next = one;
        one.next = two;
        two.next = three;
        ReorderList reorder = new ReorderList();
        reorder.reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseHead = this.reverse(slow.next);

        slow.next = null;
        merge(head, reverseHead);
    }


    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
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

    private void merge(ListNode head1, ListNode head2) {

        while (head1 != null & head2 != null) {
            ListNode next = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next;
            head2 = next2;
            head1 = next;
        }
    }
}
