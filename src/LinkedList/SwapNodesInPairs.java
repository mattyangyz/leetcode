package LinkedList;

/**
 * 24. Swap Nodes in Pairs
 * Medium
 * <p>
 * 2369
 * <p>
 * 172
 * <p>
 * Add to List
 * <p>
 * Share
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * 思路: https://leetcode.com/problems/swap-nodes-in-pairs/discuss/11046/My-simple-JAVA-solution-for-share
 */
public class SwapNodesInPairs {

    public ListNode swapPair(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;                  // 这个不能省
        ListNode prev = dummy;

        // 这里的写法跟get middle差不多，只不过get middle是fast
        // 而且这里的写法是跟 reverse nodes in k group有点类似
        while (prev.next != null && prev.next.next != null) {
            ListNode swap1 = prev.next;
            ListNode swap2 = prev.next.next;

            prev.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            prev = swap1;
        }
        return dummy.next;
    }
}
