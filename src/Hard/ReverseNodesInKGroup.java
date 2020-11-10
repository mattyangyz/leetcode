
package Hard;

import LinkedList.ListNode;

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
 * 思路: https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11440/Non-recursive-Java-solution-and-idea
 * 找到一个局部需要reverse的，进行reverse 本来的尾部就是新的头，本来的头部就是新的尾部， 然后让prev的next指向新的头部，然后更新prev。
 * prev应该不断更新为指向reverse完的尾部，这样这个尾部就能跟下一个局部的头连接起来
 * <p>
 * <p>
 * tempNode = 0
 * 0   1   2   3    4     5     6     7    8     k = 3
 * prev = 0
 * <p>
 * prev.next = newHead which is 3 and prev moves to 1, 接下来 一会指向 下一个section的 6
 * 0     3      2       1        4       5      6     7     8
 * 然后接下来再
 */

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode tempNode = new ListNode(0);    // 这个是要return的头
        ListNode prev = tempNode;

        ListNode runner = head;                   // 这个是需要不断往前走的runner node


        while (runner != null) {
            ListNode kLast = runner;
            int num = k;

            while (num > 0 && runner != null) {  // 走局部 找到局部的范围
                runner = runner.next;
                num--;
            }

            if (num != 0) {
                prev.next = kLast;      //这里记得不要漏了，因为 prev = kLast的时候还没有把新的prev的next连上的。
                break;
            }

            ListNode newHead = reverse(kLast, k);

            prev.next = newHead;
            prev = kLast;              // prev应该不断更新为指向reverse完的尾部，这样这个尾部就能跟下一个局部的头连接起来
        }

        return tempNode.next;
    }

    // standard reverse node, return the new head, which is the old tail.
    public ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null && k > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}
