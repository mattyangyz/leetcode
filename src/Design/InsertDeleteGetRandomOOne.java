package Design;


import java.util.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 * <p>
 * 思路： 用一个arraylist去存元素的值， 用于random的时候。 然后用map去存value跟他们的index的对应关系。
 * 当arraylist remove的时候， runtime是O（N）， 但是当remove最后一个index的element的时候， 是O（1） 因为
 * 不需要shift。这题的关键是swap.
 */
public class InsertDeleteGetRandomOOne {

    ArrayList<Integer> list;
    Map<Integer, Integer> valToIndex;

    public InsertDeleteGetRandomOOne() {
        valToIndex = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        list.add(val);
        valToIndex.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        int index = valToIndex.getOrDefault(val, -1);
        if (index == -1) {
            return false;
        }

        Collections.swap(list, index, list.size() - 1);         // 这里是关键。
        int swapWith = list.get(index);
        valToIndex.put(swapWith, index);
        list.remove(list.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }
}
