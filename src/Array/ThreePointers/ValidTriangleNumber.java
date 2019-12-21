package Array.ThreePointers;


import java.util.Arrays;

/**
 * Linkedin
 * <p>
 * <p>
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen
 * from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * <p>
 * 思路：https://leetcode.com/problems/valid-triangle-number/discuss/128135/A-similar-O(n2)-solution-to-3-Sum
 * <p>
 * a + b > c 固定一个C， 从后面开始。 然后A从前面开始， B从C前一个数开始.
 * <p>
 *  i                   j   k
 * [3, 19, 22, 24, 35, 82, 84] 如果i + j > k 则j-1的所有index都可以拿，因为里边的数字全部比3要大的。
 * 一旦找到了 加入结果里面 然后把 j--，如果没有的话 就对i 进行一个++的操作。
 */
public class ValidTriangleNumber {

    public static int trigangleNumber(int[] nums) {

        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;

                } else {
                    i++;
                }
            }

        }
        return count;
    }
}
