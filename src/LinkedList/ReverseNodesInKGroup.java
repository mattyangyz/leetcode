package LinkedList;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * Example:
 * <p>
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * 思路: 大体思路对于list进行一个分段的recursive 1234567 k=3对456跟123进行局部的recursive。7会被单独返回到456那一层，然后
 * 在那一层进行一个翻转，然后返回6到上一层的123那里然后进行翻转所以结果是321 654 7这样的。 注意一个小节 就是当前list的size小于k的时候
 * 不进行翻转。
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 0;
        ListNode cur = head;

        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            // 1 2 3 4 5 6 7 返回到 4 5 6的时候，cur等于7，head还是4. 第一次翻转的时候变成 4->7 5->6 这是head等于5 cur等于4
            // 第二次翻转 5->6->7 第三次翻转 6->5->4->7。其实cur也可以理解为prev。
            while (count > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
                count--;
            }
            head = cur;
        }
        return head;
    }
}
