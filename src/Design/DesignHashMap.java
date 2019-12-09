package Design;

class Entry<K, V> {
    K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    // getters, equals, hashCode and toString
}


public class DesignHashMap<K, V> {

    private int capacity = 16;
    Entry<K, V> map[] = new Entry[capacity];

    private int hashing(K key) {
        return key.hashCode() % capacity;
    }

    public V get(K key) {

        int hashIndex = hashing(key);
        if (key == null || map[hashIndex] == null) {
            return null;
        }
        if (map[hashIndex].next == null) {
            return map[hashIndex].getValue();
        }

        Entry<K, V> iterator = map[hashIndex].next;
        while (iterator != null) {
            if (key.equals(map[hashIndex].getKey())) {
                return map[hashIndex].getValue();
            }
            iterator = iterator.next;
        }
        return null;
    }

    public V insert(K key, V value) {
        if (key == null) {
            map[0] = new Entry<>(key, value);
        }
        int hashIndex = hashing(key);

        if (map[hashIndex] == null) {
            map[hashIndex] = new Entry<>(key, value);
            return value;
        }

        Entry<K, V> iterator = map[hashIndex];
        while (iterator != null) {
            if (map[hashIndex].getKey().equals(key)) {
                V ans = map[hashIndex].getValue();
                map[hashIndex].setKey(key);
                map[hashIndex].setValue(value);
                return ans;
            }
            if (iterator.next == null) {
                Entry<K, V> entry = new Entry<>(key, value);
                iterator.next = entry;
                return value;
            }
            iterator = iterator.next;
        }
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            V ans = map[0].getValue();
            map[0] = null;
            return ans;
        }

        int hashIndex = hashing(key);

        if (map[hashIndex] == null) {
            return null;
        }
        if (map[hashIndex].next == null && map[hashIndex].getKey().equals(key)) {
            V ans = map[hashIndex].getValue();
            map[hashIndex] = null;
            return ans;
        }

        Entry<K, V> prev = map[hashIndex];
        Entry<K, V> curr = map[hashIndex].next;

        while (curr != null) {
            if (curr.getKey().equals(key)) {
                V ans = curr.getValue();
                prev.next = curr.next;
                return ans;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

}
