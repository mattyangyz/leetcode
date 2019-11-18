package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class InsertDeleteGetRandomOOneDuplicatesAllowed {

    ArrayList<Integer> nums;
    Map<Integer, LinkedHashSet<Integer>> valToLocations;

    public InsertDeleteGetRandomOOneDuplicatesAllowed() {
        nums = new ArrayList<>();
        valToLocations = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean alreadyExist = valToLocations.containsKey(val);
        if (!alreadyExist) {
            valToLocations.put(val, new LinkedHashSet<>());
        }
        valToLocations.get(val).add(nums.size());
        nums.add(val);
        return !alreadyExist;
    }

    public boolean remove(int val) {
        if (!valToLocations.containsKey(val)) {
            return false;
        }

        LinkedHashSet<Integer> valLocationSet = valToLocations.get(val);
        int valIndex = valLocationSet.iterator().next();

        int lastIndexVal = nums.get(nums.size() - 1);
        LinkedHashSet<Integer> lastIndexValLocations = valToLocations.get(lastIndexVal);

        nums.set(valIndex, lastIndexVal);  // replace val at its index with very last number
        valLocationSet.remove(valIndex);        // then remove val's old index location in its LinkedHashSet

        if (valIndex != nums.size() - 1) {
            lastIndexValLocations.remove(nums.size() - 1);
            lastIndexValLocations.add(valIndex);
        }
        nums.remove(nums.size() - 1);
        if (valLocationSet.isEmpty()) {
            valToLocations.remove(val);
        }
        return true;
    }

    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }

}
