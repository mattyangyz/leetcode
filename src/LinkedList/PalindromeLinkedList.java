package LinkedList;


/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2
 * Output: false
 * Example 2:
 * <p>
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * <p>
 * https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
 * <p>
 * 思路， 用两个pointer找到mid先，然后对于mid.next的元素进行一个reverse，然后再比较
 */

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode middle = getMiddle(head);
        ListNode secondPart = reverse(middle.next);

        while (head != null && secondPart != null) {
            if (head.val != secondPart.val) {
                return false;
            }
            head = head.next;
            secondPart = secondPart.next;
        }
        return true;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        while (head != null) {
            ListNode preserveNext = head.next;
            head.next = prev;
            prev = head;
            head = preserveNext;
        }
        return prev;
    }
}
