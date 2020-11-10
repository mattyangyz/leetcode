package LinkedList;

/**
 * Linkedin
 * <p>
 * <p>
 * <p>
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */

// 先计算list的size，然后把最后一个node跟头连起来。最后把新的头的前一个node的next设置为null
// 要想明白怎么的到新的头的位置，就是length - （n % length），
// 因为题目要求是to the right所以要用length - 计算出来的index
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lastElement = head;
        int length = 1;
        while (lastElement.next != null) {
            lastElement = lastElement.next;
            length++;
        }
        lastElement.next = head;

        // length - n % length这个是非常关键的
        // 1,2,3,4,5,6,7,8,9,10,11  -> 11 - 4 = 7   那就说明 8 是头。
        for (int i = 1; i < length - n % length; i++) { // length - n % length 实际上是找出头是谁
            head = head.next;
        }
        // 为什么从1开始呢，因为只需要走到新的head的前一个位置就够了，因为head前面的那个node的next要设置null

        ListNode result = head.next;
        head.next = null;
        return result;
    }
}
