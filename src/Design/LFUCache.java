package Design;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted.
 * This number is set to zero when the item is removed.
 * <p>
 * <p>
 * 思路 -> At first I didn't understand why we didn't need to care about nextMin and we just could add 1 to min.
 * Now it makes sense that min will always reset to 1 when adding a new item. And also,
 * min can never jump forward more than 1 since updating an item only increments it's count by 1.
 */

public class LFUCache {

    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToCount;
    HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToLRUKeys = new HashMap<>();
    }

    //
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key);                          // remove key from current count since we will inc count
        if (count == min && countToLRUKeys.get(count).size() == 0) {    // 因为上面remove了 所以这里要检查
            min++;                                                      // 为什么只需要min++就行 而不需要care下一个min是多少呢？
        }                                                               // 因为这个key这时候被get了， 所以他的count会+1， 所以min
        // 只需要加一就行。 所以size 不为0的 说明当前min还有值， 不能加。
        putCount(key, count + 1);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);           // update key's value
            get(key);                           // update key's count
            return;
        }
        if (keyToVal.size() >= cap) {
            evict(countToLRUKeys.get(min).iterator().next());       // evict LRU from this min count bucket
        }
        min = 1;                                                    // 因为放了一个新的key近来 所以frequence会变成1
        putCount(key, min);
        keyToVal.put(key, value);
    }

    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        if (countToLRUKeys.get(count) == null) {
            countToLRUKeys.put(count, new LinkedHashSet<>());
        }
        countToLRUKeys.get(count).add(key);
    }
}
