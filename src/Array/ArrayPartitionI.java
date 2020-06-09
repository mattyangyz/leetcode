package Array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * <p>
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * <p>
 * 题意: 两两一对， 然后每对中取最小的那一个，然后这些最小的相加起来。 求最大值是多少。
 */

// 用一个array，遍历一遍把数字出现的次数记录下来。 因为array的range题目规定了是-10000到10000，所以可以这样做。
// 然后遍历这个array看该index对应的数字有没有出现过，而且如果first是true的话，就加到结果中。
public class ArrayPartitionI {

    public int arrayPairSumNlongN(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }


    public int arrayPairSum(int[] numss) {

        int maxValue = 10000;
        int[] array = new int[maxValue * 2 + 1];    // 加一是为了把0算进去。

        for (int num : numss) {
            array[num + maxValue] += 1;             // 这里记录的是出现的次数。 这是为了handle重复数字的问题。
        }

        int ans = 0;
        boolean first = true;
        int start = -maxValue;

        while (start <= maxValue) {

            if (array[start + maxValue] == 0) {
                start++;
                continue;
            }
            if (first) {
                ans += start;
                first = false;
            } else {
                first = true;
            }
            array[start + maxValue] -= 1;
        }
        return ans;

    }
}
