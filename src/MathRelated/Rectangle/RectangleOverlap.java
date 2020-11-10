package MathRelated.Rectangle;

/**
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
 * <p>
 * Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.
 * <p>
 * Given two (axis-aligned) rectangles, return whether they overlap.
 * <p>
 * Example 1:
 * <p>
 * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * Output: true
 * Example 2:
 * <p>
 * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * Output: false
 * Notes:
 * <p>
 * Both rectangles rec1 and rec2 are lists of 4 integers.
 * All coordinates in rectangles will be between -10^9 and 10^9.
 * <p>
 * <p>
 * 思路: 没什么算法，把六种overlap的情况画出来就知道结果了。 给点时间，能理解的。
 *
 *              x4y4
 *      |-----|
 *      |     |
 *      |   |-|----| x2y2
 * x3y3 |- -|-|    |
 *          |------|
 *         x1y1
 *
 */

public class RectangleOverlap {

    public boolean isRectabgleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int x2 = rec1[2];
        int y1 = rec1[1];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int x4 = rec2[2];
        int y3 = rec2[1];
        int y4 = rec2[3];

        return x4 > x1 && y4 > y1 && x3 < x2 && y3 < y2;
    }
}
