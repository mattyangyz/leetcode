package Design;


/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * <p>
 * Example:
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 * <p>
 * Note:
 * <p>
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 * <p>
 * 意思: 每一个bucket的时候，第一个肯定是dummy node，因为这样方便remove的时候可以拿到prev的ref然后prev.next.next去remove
 * 同时如果一个key对应的index不是null，只是代表有可能这个key存在，不能100%保证的，需要traverse list看是否存在。
 * 同时找的时候永远都是return prev的元素，如果prev.next == null就是代表没有找到。这三个点都很关键。同一个index 下面的entry list
 * 对应的可能是不同的key的，因为这是一种碰撞的情况。
 */

public class DesignHashMapLeetcode {

    class Entry {
        int key;
        int value;
        Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    private int CAPACITY = 16;
    private Entry[] entries;

    /**
     * Initialize your data structure here.
     */
    public DesignHashMapLeetcode() {
        entries = new Entry[CAPACITY];
    }

    private int hashing(int key) {
        return Integer.hashCode(key) % CAPACITY;
    }

    private Entry find(Entry head, int key) {
        Entry entry = head;
        Entry prev = null;
        while (entry != null && entry.key != key) {
            prev = entry;
            entry = entry.next;
        }
        return prev;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {           // 第一个一定要放 -1 -1。
        int index = hashing(key);
        if (entries[index] == null) {
            entries[index] = new Entry(-1, -1);
        }

        Entry preEntry = find(entries[index], key);
        if (preEntry.next == null) {
            preEntry.next = new Entry(key, value);
        } else {
            preEntry.next.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hashing(key);
        if (entries[index] == null) {
            return -1;
        }
        Entry prevEntry = find(entries[index], key);
        return prevEntry.next == null ? -1 : prevEntry.next.value;  // 如果prev.next == null就是等于没找到
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hashing(key);
        if (entries[index] == null) {
            return;
        }
        Entry prev = find(entries[index], key);
        if (prev.next == null) {                // 没有找到，即使这个key 对应的index有value，然后这个key不存在。
            return;
        } else {
            prev.next = prev.next.next;
        }
    }


}
