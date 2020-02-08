package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */

public class intersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        if (set1.size() < set2.size()) {
            return intersect(set1, set2);
        } else {
            return intersect(set2, set1);
        }

    }

    private int[] intersect(Set<Integer> set1, Set<Integer> set2) {
        int[] array = new int[set1.size()];
        int index = 0;

        for (Integer value : set1) {
            if (set2.contains(value)) {
                array[index++] = value;
            }
        }
        int[] ans = new int[index];
        for (int i = 0; i < index; i++) {
            ans[i] = array[i];
        }
        return ans;
    }
}
