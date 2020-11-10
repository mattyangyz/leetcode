package MathRelated.BitMultiplication;

import LinkedList.ListNode;

/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {

        int num = 0;
        while (head != null) {
            num = num << 1;
            num |= head.val;
            head = head.next;
        }
        return num;
    }
}
