package Array.FlipElement;

import java.util.ArrayList;
import java.util.List;

/**
 * // when find a number i, flip the number at position i-1 to negative.
 * // if the number at position i-1 is already negative, i is the number that occurs twice.
 * <p>
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 */

public class FindAllDuplicatesInAnArray {

    public List<Integer> findDuplicates(int[] array) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int index = Math.abs(array[i]) - 1;
            if (array[index] < 0) {
                res.add(index + 1);
            }
            array[index] = -array[index];
        }
        return res;
    }
}
