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

        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode permHead = head;
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            head.next = new ListNode((v1 + v2 + carry) % 10);
            carry = (v1 + v2 + carry) / 10;                         // 注意这里要带上之前的carry去算carry
            head = head.next;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        if(carry != 0){
            head.next = new ListNode(1);
        }
        return permHead.next;
    }
}
