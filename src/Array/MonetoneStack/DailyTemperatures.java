package Array.MonetoneStack;


import java.util.Stack;

/**
 * Linkedin
 * <p>
 * 关键 由尾部开始 保持一个单调递减的stack， 从最后一位开始。当看到curr比stack的top大的时候， 持续把stack的pop，直到遇到curr比stack top小的时候，
 * 然后peek一下top 计算此时的位置，然后把curr的pos放到stack里面
 * <p>
 * stack一直都是保持由下往上递减的状态的， 这个是关键。pop的时候不需要担心 这个被pop的index会不会没被处理 因为他被pop之前已经被处理过了
 * <p>
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 *
 * 思路： 保持一个由底往上的一个递减stack, 当遇到当前元素比stack的top小的时候 就直接peek一下top的位置 计算。 如果当前元素比stack的peek大的话，就不断
 * 地pop，知道遇到前一句话那种当前元素比stack的top小的这种情况。
 */

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] t) {

        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack();      // 这个stack是用来保存index的。

        for (int i = t.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && t[i] >= t[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
