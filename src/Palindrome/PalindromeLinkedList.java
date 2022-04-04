package Palindrome;


import LinkedList.ListNode;

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

// 基数的时候 1 2 4 2 1， 这时候的middle会落在 4 这里， 但是while loop的head会在走到这个 4 之前就结束了，
// 但是没关系的 因为这个 4 会成立的，所以直接返回true就行了鹅在结尾的时候
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode middle = getMiddle(head);
        ListNode secondPart = reverse(middle);

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

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
