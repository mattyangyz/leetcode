package TwoPointers;

import java.util.Arrays;

/**
 * Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [34,23,1,24,75,33,54,8], K = 60
 * Output: 58
 * Explanation:
 * We can use 34 and 24 to sum 58 which is less than 60.
 * Example 2:
 * <p>
 * Input: A = [10,20,30], K = 15
 * Output: -1
 * Explanation:
 * In this case it's not possible to get a pair sum less that 15.
 */

public class TwoSumLessThanK {

    public int twoSumLessThanK(int[] A, int K) {

        Arrays.sort(A);
        int max = -1;
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) {
                max = Math.max(max, sum);
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
