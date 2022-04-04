package Design;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * 非常重要
 *
 * 一个hashmap加一个double linked list， map的value就是list的node。
 *
 * doubly linked list + hashmap + dummy head + dummy head, 重点是先remove 在 moveTohead， 顺序不能乱。
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


class LRUCache {

    class Node {
        int key;        //这里的key是需要的，因为第75行remove的时候需要
        int value;
        Node next;
        Node prev;
    }

    private Map<Integer, Node> map;
    private Node first;
    private Node tail;
    private int capacity;
    private int size = 0;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        first = new Node();
        tail = new Node();
        first.next = tail;
        tail.prev = first;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);   // 这里非常关键！！
            this.delete(node);          // 重点是先remove 在 moveTohead， 顺序不能乱。因为我们挪动的是node的指针，而不是创建一个新的在head
            this.insertFirst(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            delete(map.get(key));
            insertFirst(map.get(key));
        } else {
            if (capacity == size) {
                map.remove(tail.prev.key);  // 这里一定要先remove再delete，不然tail.prev就不是原来的，而是更新过得
                delete(tail.prev);
            } else {
                size++;
            }
            Node node = new Node();
            map.put(key, node);
            node.key = key;
            node.value = value;
            this.insertFirst(node);
        }
    }

    private void delete(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertFirst(Node node) {
        node.next = first.next;
        node.prev = first;

        first.next.prev = node;
        first.next = node;
    }
}