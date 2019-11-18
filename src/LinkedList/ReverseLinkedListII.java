//package LinkedList;
//
//
//https://www.cnblogs.com/grandyang/p/4306611.html
//
//public class ReverseLinkedListII {
//
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//
//        if (head == null) {
//            return null;
//        }
//
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode prePointer = dummy;
//
//        for (int i = 0; i < m - 1; i++) {
//            prePointer = prePointer.next;
//        }
//
//        ListNode start = prePointer.next;
//        ListNode then = start.next;
//
//        for (int i = 0; i < n - m; i++) {
//
//        }
//    }
//}
