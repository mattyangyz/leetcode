package LinkedList.Cycle;


import LinkedList.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * <p>
 * To represent a cycle in the given linked list,
 * we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
 * If pos is -1, then there is no cycle in the linked list.
 * <p>
 * Use two pointers, walker and runner.
 * walker moves step by step. runner moves two steps at time.
 * if the Linked List has a cycle walker and runner will meet at some
 * point.
 */

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        linkedListCycle.hasCycle(node1);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;

        // 这里跟getMiddle是一样的。
        while (runner.next != null && runner.next.next != null && walker != runner) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker == runner;
    }
}
