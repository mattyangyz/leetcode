package MathRelated.AddNumberAndString;

import LinkedList.ListNode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * <p>
 * 思路: 这题要用两个stack去做，而且要注意这个res list是从后往前填满的，这就要注意如何控制的问题，这一点跟
 * add two numers 1不一样，而且处理最后一个是carry的方法也不一样。
 */

public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode list = new ListNode(0);
        int sum = 0;
        int carry = 0;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            sum += carry;
            list.val = sum % 10;
            carry = sum / 10;
            sum = 0;

            ListNode head = new ListNode(carry);
            head.next = list;
            list = head;
        }
        return list.val == 0 ? list.next : list;
    }
}
