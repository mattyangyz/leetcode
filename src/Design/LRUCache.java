package Design;


import java.util.HashMap;

/**
 *
 * 非常重要
 *
 * doubly linked list + hashmap + dummy head + dummy head
 *
 * 关键是要define两个function， 一个是delete， 一个是move to head。跟一个dummy tail 和 dummy head
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 */


class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {


    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private int count = 0;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            this.deleteNode(node);
            this.addToHead(node);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            this.deleteNode(node);
            this.addToHead(node);
        }
        else{
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                this.addToHead(node);
                count++;
            }
            else{
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                this.addToHead(node);
            }
        }

    }

}
