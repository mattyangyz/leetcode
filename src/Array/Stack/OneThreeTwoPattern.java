package Array.Stack;

import java.util.Stack;

/**
 * 难， 不行就死机。亚麻高频。
 * <p>
 * <p>
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj,
 * ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as
 * input and checks whether there is a 132 pattern in the list.
 * <p>
 * Note: n will be less than 15,000.
 * <p>
 * Example 1:
 * Input: [1, 2, 3, 4]
 * <p>
 * Output: False
 * <p>
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 * <p>
 * Output: True
 * <p>
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * <p>
 * Output: True
 * <p>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * <p>
 * <p>
 * 思路:
 * <p>
 * OneThreeTwoPattern: To reduce the time complexity down to O(n^2), we need to do some observations.
 * In the naive solution above, let's assume we have index j fixed, what should index i be so
 * that it is most probable we will have a 132 pattern? Or in other words, what should i be so
 * that we will be certain there is no such 132 pattern for combination (*, j, *)
 * whenever there is no 132 pattern for combination of (i, j, *)? (Here * means any index before or after index j.)
 * <p>
 * The answer lies in the fact that once the first two numbers nums[i] and nums[j] are fixed,
 * we are up to find the third number nums[k] which will be within the range (nums[i], nums[j])
 * (the two boundaries are exclusive). Intuitively the larger the range is, the more likely there will be a number "falling into" it.
 * Therefore we need to choose index i which will maximize the range (nums[i], nums[j]).
 * Since the upper bound nums[j] is fixed, this is equivalent to minimizing the lower bound nums[i].
 * Thus it is clear i should be the index of the minimum element of the subarray nums[0, j) (left inclusive, right exclusive).
 * <p>
 * Since we are scanning index j from the beginning of the input array nums,
 * we can keep track of the minimum element of the subarray from index 0 up to j - 1 without rescanning it.
 * Therefore the first two loops in the naive solution can be combined into one and leads to the following O(n^2) solution
 * <p>
 * 也就是说j走右边的同时keep track一个最小的num[i]其实是，然后对于k， k必定是在min和nums[j]之间的。
 */

public class OneThreeTwoPattern {

    public boolean find132patternWithONTime(int[] nums) {

        int min = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            min = Math.min(nums[j], min);
            if (min == nums[j]) {
                continue;
            }
            for (int k = nums.length - 1; k > j; k--) {
                if (min < nums[k] && nums[k] < nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //                                                          1
    //                                                          2
    // 为什么88行要一直pop呢，是因为想想 2.5 7 1 2 3这个例子， stack是  3 要不断的把mid扩大，才能容易找到更多比mid小的数字。
    // 分三步去理解，一是 1 2 3 是一部分， 而是 7 是一部分， 最后是 2.5 这里的一部分。 既然7比mid要大, 那么肯定比2.5要大。
    public boolean find132pattern(int[] nums) {
        int mid = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < mid) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) { //
                    mid = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
