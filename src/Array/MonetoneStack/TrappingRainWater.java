package Array.MonetoneStack;

import java.util.Stack;

/**
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * 思路: 利用stack去找左边和右边的boundary，然后通过index和面积去计算高度。
 *
 */

// 这是一个单调递减的stack。
public class TrappingRainWater {

    public static void main(String[] args) {

        TrappingRainWater.trap(new int[]{10, 5, 6, 20});

    }

    public static int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int i = 0;
        int n = height.length;
        int res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {                    // 千万注意这里else block绝对不能i++， 因为不知道这个i会不会比current top之前的要高，要是是的话
                int t = s.pop();        // 还可以组成水位置。
                if (s.isEmpty()) {
                    continue;
                }

                // Math.min(height[i], height[s.peek()]两边取最小值
                // 要理解为什么是 i - s.peek() - 1，即便左边两个不是相邻的也能这么做 画出10，5, 6, 20这个就会知道
                // 因为到10 5的时候6进来，然后把5pop出去计算，然后再下一次进来的时候10，6，20，这时候t == 6，从20开始
                // 左边界可以拿到10，而不是t - 1（也就是5）. 所以必须得i - s.peek() - 1
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }
}
