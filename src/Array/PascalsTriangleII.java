package Array;

import java.util.Arrays;
import java.util.List;

/**
 * 1, 0, 0, 0, 0
 * 1, 1, 0, 0, 0
 * 1, 2, 1, 0, 0 -> using one array to accomplish this. REMEMBER, the first one is always zero.
 * 1, 3, 3, 1, 0
 * 1, 4, 6, 4, 1
 * <p>
 * <p>
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 * Follow up:
 * <p>
 * Could you optimize your algorithm to use only O(k) extra space?
 */

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex + 1];
        Arrays.fill(ans, 0);
        ans[0] = 1;

        for (int i = 0; i <= rowIndex; i++) {

            for (int j = i; j > 0; j--) {
                ans[j] = ans[j] + ans[j - 1];
            }
        }
        return Arrays.asList(ans);
    }
}
