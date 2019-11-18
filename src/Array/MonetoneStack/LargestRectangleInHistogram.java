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

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] nums) {
        int length = nums.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();   // 存index
        for (int i = 0; i <= nums.length; i++) {

            int currHeigh = (i == length ? 0 : nums[i]);

            if (stack.isEmpty() || currHeigh > nums[stack.peek()]) {
                stack.push(i);
            } else {
                int currTop = stack.pop();
                // 重点在这里
                max = Math.max(max, nums[currTop] * (stack.isEmpty() ? i : i - stack.peek() - 1));
                i--;
            }
        }
        return max;
    }

}
