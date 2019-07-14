package Array;

/**
 *
 * TODO: 需要去解释为什么需要移动短的那一边
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 * 双指针，头和尾的指针哪个先向中间遍历。当然是高度矮的那个
 * 如果是高度高的那个， 那么矮的那边就不可能遍历到高的现在遍历的那个点 （宽度不用考虑）
 * 没有非常特别的edge case需要考虑
 *
 *
 */

public class ContainerWithMostWater {
    public int maxAreaBruteForce(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - 1));
            }
        }
        return maxArea;
    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (left < right) {
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
