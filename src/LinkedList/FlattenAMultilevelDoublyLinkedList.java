package LinkedList;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 * <p>
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * 1---2---3---4---5---6--NULL
 * |
 * 7---8---9---10--NULL
 * |
 * 11--12--NULL
 * <p>
 * Output:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * <p>
 * <p>
 * 思路: Basic idea is straight forward:
 * <p>
 * Start form the head , move one step each time to the next node
 * When meet with a node with child, say node p, follow its child chain
 * to the end and connect the tail node with p.next, by doing this we merged the child chain back to the main thread
 * Return to p and proceed until find next node with child.
 * Repeat until reach null
 */

// 一个一个node地走，如果current有child的话，就开始赶回。先拿到child chain的尾部，然后把child chain的尾部跟
// current的next链接起来，同时curr的next跟child chain的尾部链接起来。然后curr的next指向child chain的头部，
// 然后child chain的头部的prev指向current，然后把child的ref给设置成null。这样就行了。
public class FlattenAMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;

        while (curr != null) {
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            Node temp = curr.child;
            while (temp.next != null) {  // find the tail of the child and link it to curr.next
                temp = temp.next;
            }

            temp.next = curr.next;      // connect the tail of child to current's next
            if (curr.next != null) {
                curr.next.prev = temp;
            }

            curr.next = curr.child;     //connect curr's next to it's child
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }
}
