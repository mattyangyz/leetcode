package MathRelated.Rectangle;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * <p>
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * <p>
 * Rectangle Area
 * <p>
 * Example:
 * <p>
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
 * Output: 45
 * <p>
 * 思路: 先计算出a和b的面积，然后用max和min来判断是否有重合的部分
 */


public class RectangleArea {

    public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {

        int areaA = (c - a) * (d - b);
        int areaB = (g - e) * (h - f);

        // 判断重叠 左边的边去最大值 右边的边取最小值
        // 如果 left 的 大于 right 的说明有重叠
        int left = Math.max(a, e);
        int right = Math.min(c, g);

        int top = Math.min(d, h);
        int bottom = Math.max(b, f);

        int overlap = 0;
        if (right > left || top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        return areaA + areaB - overlap;
    }
}
