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
 *
 * 题意: implement 两个方法 get 和 put。当满了的时候，把用得最少的key-value给去掉。如果有平手的话，去掉那个access过得时间距离现在
 * 最远的。
 *
 * 思路 -> At first I didn't understand why we didn't need to care about nextMin and we just could add 1 to min.
 * Now it makes sense that min will always reset to 1 when adding a new item. And also,
 * min can never jump forward more than 1 since updating an item only increments it's count by 1.
 */

// 如果update min呢？ 当当前get的时候，如果这个key的freq刚好是min 而且同一个freq的次数已经没有别的key了，那么就update 这个
// 这个min，不然的话min不变。
// get的时候看看这个key是否存在，是的话 就从LinkedHashSet中移除。 然后看这个key对应的count是否等于min，是的话， 而且min对应的hashset
// 已经没有任何元素了， 就更新一下min。接着完成上面的以后就把新的count freq更新一下。然后就return
// put的时候看这个key是否已经存在 是的话就更新一下然后顺便call一下get(更新对应的min 如果有需要的话)，如果size已经满了的话， 就remove一下在
// linkedHashSet最开头的元素，因为这个是least recently used的。然后需要更新min，因为新进来的元素都是min = 1的，然后就把这个freq count和
// key-value都update一下。
// todo： 关键是想到怎么保持平手时候的顺序, 需要用一个linkedHashSet
public class LFUCache {

    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToCount;

    // key 是某一个frequency，value 是 对应的freq 对应出现过得key的顺序
    HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;        // 这个是为了当一个key同样的freq时候，看谁是least recently used的，然后remove

    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToLRUKeys = new HashMap<>();
    }


    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key);                          // remove key from current count since we will inc count
        if (count == min && countToLRUKeys.get(count).size() == 0) {    // 因为上面remove了 所以这里要检查
            min++;                                                      // 为什么只需要min++就行 而不需要care下一个min是多少呢？
        }                                                               // 因为这个key这时候被get了， 所以他的count会+1， 所以min
        // 只需要加一就行。 若size 不为0的 说明当前min还有值， 不能加。
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
        keyToCount.remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        if (countToLRUKeys.get(count) == null) {
            countToLRUKeys.put(count, new LinkedHashSet<>());
        }
        countToLRUKeys.get(count).add(key);
    }
}
