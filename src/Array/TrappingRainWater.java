package Array;

/**
 * https://leetcode.wang/leetCode-42-Trapping-Rain-Water.html
 * <p>
 * 说到栈，我们肯定会想到括号匹配了。我们仔细观察蓝色的部分，可以和括号匹配类比下。每次匹配出一对括号（找到对应的一堵墙），就计算这两堵墙中的水。
 * <p>
 * <p>
 * 0， 1， 0， 2， 1， 0， 1， 3， 2， 1， 2， 1
 * <p>
 * *
 * *              *   *      *
 * *      *   *      *   *   *  *   *   *
 * 0， 1， 2， 3， 4， 5， 6， 7， 8， 9， 0， 1
 * l                             r
 * leftMax : 1
 * -->
 * <p>
 * rightMax : 1
 * -->
 * <p>
 * res
 * <p>
 * left   1
 * right 10
 */


public class TrappingRainWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(height[left], leftMax);
                res += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
