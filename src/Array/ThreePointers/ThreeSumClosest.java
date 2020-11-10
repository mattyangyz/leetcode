package Array.ThreePointers;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element.
 * If the sum is less than target, it means we have to add a larger element so next element move to the next.
 * If the sum is greater, it means we have to add a smaller element so last element move to the second last element.
 * Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far,
 * then replace result with it, otherwise keep iterating.
 */

// 跟3sum基本一样，但是不需要处理重复的问题。 而且这题的关键是先取一个数作为res，这里是关键。

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];      // assume this is the closest first

        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;

            while (start < end) {

                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }

                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
