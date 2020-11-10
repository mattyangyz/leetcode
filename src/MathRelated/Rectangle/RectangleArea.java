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

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaA = (C - A) * (D - B);
        int areaB = (G - E) * (H - F);

        int overLap = 0;

        if (A < G && B < H && C > E && D > F) {           // 跟那题判断rectangle有没有overlap的是一样的，这一行。

            int left = Math.max(A, E);                  // 求出overlap的rectangle
            int right = Math.min(C, G);

            int top = Math.min(D, H);
            int bottom = Math.max(B, F);

            overLap = (right - left) * (top - bottom);
        } else {
            overLap = 0;
        }

        return areaA + areaB - overLap;
    }
}
