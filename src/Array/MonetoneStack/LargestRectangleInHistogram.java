package Array.MonetoneStack;


import java.util.Stack;

/**
 * 重要 要理解
 * <p>
 * https://www.1point3acres.com/bbs/thread-204388-1-1.html
 * <p>
 * https://www.cnblogs.com/grandyang/p/8887985.html
 * <p>
 * https://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 * <p>
 * https://www.youtube.com/watch?v=OT-36D83Fns
 * <p>
 * 1) Create an empty stack.
 * <p>
 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 * a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 * b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
 * <p>
 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 * <p>
 * Following is implementation of the above algorithm.
 * <p>
 * 用stack， 当curr比stack顶端小的话， 则可以伸展过去， 伸展多少呢， pop多少个就伸展多少个（直到pop到比curr小的才停
 * 意思就是把curr为右边界，能向左推进多少
 * <p>
 * 2， 1， 5， 6， 2， 3
 * <p>
 * 到第二个2的时候， 可以向左5， 6， 直到1。 然后把5，6从stack给pop出来（我们不在意5和6的高度，因为高度是2决定了已经）， 然后把2加进去， 1， 2
 * <p>
 * 中心思想是维护一个递增的stack，只存放单调递增的索引！！
 * <p>
 * 如果curr比stack的top高， 则curr进stack
 * 如果curr比stack的top低， 则pop， 直到遇到比curr小的元素
 * <p>
 * 在pop stack的时候，把所有框起来的area都算一次
 */

// 为什么是单调递增呢，因为遇到小的时候 stack上肯定有某些bar就会结束高度了，譬如 5 6 2，5的高度是递增的 6的也是的，但是一遇到2，就表明
// 以5 和 6为左边界的面积就结束了 一开始我们只知道以6为边界的结束了 还要在走一次for loop才知道5也结束了。
// 所以返回去pop他们出来计算面积。然后width为什么要取i - stack.peek - 1呢, 下面的else那里有解释。
// https://www.youtube.com/watch?v=Bx_JMXnTCwE&t=310s
public class LargestRectangleInHistogram {


    public static int largestRectangleArea(int[] nums) {
        int length = nums.length;
        int max = 0;

        Stack<Integer> stack = new Stack<>();   // 存index

        for (int i = 0; i <= nums.length; i++) {

            int currHeigh = (i == length ? 0 : nums[i]);            // 这个是trigger point以防 1 2 3 4 5 6这种情况

            if (stack.isEmpty() || currHeigh > nums[stack.peek()]) {
                stack.push(i);
            } else {
                int currTop = stack.pop();
                // If this bar is smaller than the top of stack,
                // then keep removing the top of stack while top of the stack is greater.
                // Let the removed bar be hist[tp].
                // Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp],
                // the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
                int width = 0;
                if (stack.isEmpty()) {
                    width = i;         // 左边全拿的情况，这个要仔细想为什么要这样。开始 8 7 6 和
                } else {
                    // 这里为什么是stack.peek()而不是currTop - 1呢，因为试想5 7 6，当道6的时候就会把7pop出来计算。然后剩下
                    // 5 6 在stack里面，一旦需要计算5 6 形成面积的时候，
                    // 面积是从5开始算得（这是stack.peek的index指向的），而不是7开始算得（这是currTop - 1index指向的）
                    width = i - stack.peek() - 1;
                }
                max = Math.max(max, nums[currTop] * width);
                i--;
            }
        }
        return max;
    }

}
