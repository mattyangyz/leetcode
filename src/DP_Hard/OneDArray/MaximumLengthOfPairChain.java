package DP_Hard.OneDArray;

import java.util.Arrays;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 * <p>
 * 思路: 算是简单的dp题目。
 * <p>
 * https://www.youtube.com/watch?v=2GD2Lr51eK4
 * <p>
 * [1,2], [2,3], [3,4] ->> 当道[3,4]的时候， 要从0开始算那个可以最大化。
 */

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] memp = new int[pairs.length];

        for (int i = 0; i < pairs.length; i++) {
            memp[i] = 1;
            int localMax = 0;
            for (int j = 0; j < i; j++) {           // 对于现在的i 从0开始，看看之前的那个能联合这个curr i组成一个更大的。
                if (pairs[j][1] < pairs[i][0]) {
                    localMax = Math.max(localMax, memp[j] + 1);
                }
            }
            memp[i] = Math.max(memp[i], localMax);
        }
        return memp[pairs.length - 1];
    }
}
