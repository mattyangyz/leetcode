package MathRelated.TwoSumFamily;

import java.util.HashMap;

/**
 * Linkedin
 * <p>
 * Design and implement a Math.TwoSumFamily.TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * Example 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class TwoSumIII {

    HashMap<Integer, Integer> map;

    public TwoSumIII() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int number) {
        for (int integer : map.keySet()) {
            int complement = number - integer;
            if (complement == integer && map.get(complement) > 1) {
                return true;
            } else if (complement != integer && map.containsKey(complement)) {
                return true;
            }
        }
        return false;
    }
}
