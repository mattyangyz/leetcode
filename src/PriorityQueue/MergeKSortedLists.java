package PriorityQueue;

import LinkedList.ListNode;

import java.util.PriorityQueue;

/**
 * Linkedin
 * <p>
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */

// 题目意思: 给定一个array of linkedlist的head，然后这些list都是排好序的，合并他们。

// PriorityQueue 是正常的做法，但是就是注意怎么init这个queue，它的size是多少，要记住这里就行了。
// PQ的runtime是O(log n)，对于enqueue和dequeue的话(offer, poll, remove, add)。
public class MergeKSortedLists {

    // 这个优化的还没有看 todo
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return sort(lists, 0, lists.length - 1);

    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {

        if (lo >= hi) {
            return lists[lo];
        }
        int mid = (hi - lo) / 2 + lo;

        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, lo, mid + 1);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }


    public ListNode mergeKListsWithPriorityQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode candidate = queue.poll();
            curr.next = candidate;
            curr = curr.next;
            if (candidate.next != null) {
                queue.offer(candidate.next);
            }

        }
        return dummy.next;
    }
}
