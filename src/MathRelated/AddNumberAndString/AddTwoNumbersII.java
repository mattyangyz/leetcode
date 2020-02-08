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
 * 思路: 用list这个var来存current的value。 然后用head存左边的var， 记住这个head要存carryover。 然后挪动list到head。整个过程由
 * 右边向左边进行。 巧妙之处在于如何处理最后一位的carry over以及如何用sum来存carryover。
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

        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }
            if (!s2.isEmpty()) {
                sum += s2.pop();
            }
            list.val = sum % 10;
            ListNode head = new ListNode(sum / 10);         // todo： 巧妙处 给最后一位的carryover用
            head.next = list;
            list = head;
            sum /= 10;                                          // todo: 给普通的carryover用
        }
        return list.val == 0 ? list.next : list;
    }
}
