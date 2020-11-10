package Array.MonetoneStack;

import java.util.Stack;


/**
 * Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 * <p>
 * 思路: use stack to keep the indexes of the decreasing subsequence. 这个stack要理解为需要帮它找到比它自己大的元素的index， 这个是关键。
 * <p>
 * 第二次iterator的时候不需要再次push元素， 因为如果有元素比最后一个大的， 肯定会在第二次iterator的时候继续在stack里面，例子 4 2 8 7。
 */

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();    // 存index的
        int[] resList = new int[nums.length];

        for (int i = 0; i < resList.length; i++) {
            resList[i] = -1;
        }

        for (int i = 0; i < nums.length * 2; i++) {

            int index = i % nums.length;        // 这是为了第二次的时候，所以要 %

            while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
                resList[stack.pop()] = nums[index];
            }
            if (i < nums.length) {                // 只需要push一次就后了，想想为什么第二次不需要push。
                stack.push(i);
            }
        }

        return resList;
    }
}
