package Design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Linkedin
 * <p>
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 * <p>
 * <p>
 * <p>
 * <p>
 * https://leetcode.com/problems/all-oone-data-structure/discuss/91383/An-accepted-JAVA-solution-detailed-explanation.(HashMap-%2B-double-linked-list)
 */

public class AllOOneDataStructure {

    private Bucket head;
    private Bucket tail;
    private Map<Integer, Bucket> countBucketMap;
    private Map<String, Integer> keyCountMap;


    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket prev;

        public Bucket(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
    }

    public AllOOneDataStructure() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap();
    }

    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {                 // this is a new key
            changeKey(key, 1);
        } else {                                               // existing key
            keyCountMap.put(key, 1);
            if (head.next.count != 1) {
                addBucketAfter(new Bucket(1), head);
            }
            head.next.keySet.add(key);                      // add the string key to the bucket
            countBucketMap.put(1, head.next);               // set the countBucketMap refer to the bucket
        }
    }

    public void dec(String key) {
        if (keyCountMap.containsKey(key)) {                 // if the key exists
            int count = keyCountMap.get(key);
            if (count == 1) {
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keySet.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.size() == 0) {
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }

    private void changeKey(String key, int offset) {
        int count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket curBucket = countBucketMap.get(count);
        Bucket newBucket;
        if (countBucketMap.containsKey(count + offset)) {
            newBucket = countBucketMap.get(count + offset);
        } else {
            newBucket = new Bucket(offset + count);
            countBucketMap.put(offset + count, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);

    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        bucket.next = null;
        bucket.prev = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.prev = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;

    }
}
