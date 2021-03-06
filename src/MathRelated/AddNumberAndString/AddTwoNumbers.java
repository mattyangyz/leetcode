package MathRelated.AddNumberAndString;


import LinkedList.ListNode;

/** Linkedin
 *
 * 注意如何处理最后一个number的多出来位数问题
 *
 *you are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * Idea: Using a dummy node as a place holder. Started from its next node as the first place to add number;
 * Using mod and / to get actual number and carry bit.
 *
 */

// 要注意算carry和当前node值的时候一定要加上carry再算，而且注意while一定是||的。
// 而且要注意如何更新curr index这个问题，什么时候curr.next = newNode。
// 最后的判断carry也是一个比较容易忘记的地方。
public class AddTwoNumbers {

    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            curr = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
