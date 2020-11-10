package Array.MonetoneStack;

import java.util.Stack;

/**
 * Linkedin 重要 要理解
 * <p>
 * 基本做法跟LargestRectangleInHistogram一致， 只是中间加了一小段
 * <p>
 * We can apply the maximum in histogram in each row of the 2D matrix.
 * What we need is to maintain an int array for each row, which represent for the height of the histogram.
 * <p>
 * Please refer to https://leetcode.com/problems/largest-rectangle-in-histogram/ first.
 * <p>
 * Suppose there is a 2D matrix like
 * <p>
 * 1 1 0 1 0 1
 * <p>
 * 0 1 0 0 1 1
 * <p>
 * 1 1 1 1 0 1
 * <p>
 * 1 1 1 1 0 1
 * <p>
 * First initiate the height array as 1 1 0 1 0 1, which is just a copy of the first row.
 * Then we can easily calculate the max area is 2.
 * <p>
 * Then update the array. We scan the second row, when the matrix[1][i] is 0,
 * set the height[i] to 0; else height[i] += 1, which means the height has increased by 1.
 * So the height array again becomes 0 2 0 0 1 2. The max area now is also 2.
 * <p>
 * Apply the same method until we scan the whole matrix. the last height arrays is 2 4 2 2 0 4,
 * so the max area has been found as 2 * 4 = 8.
 * <p>
 * Then reason we scan the whole matrix is that the maximum value may appear in any row of the height.
 * <p>
 * <p>
 * 题目
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */

// 从第0个row开始当成是一个bottom，然后第1个row当成一个bottom，最后到最后一行当成bottom。
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int max = 0;
        int[] heigh = new int[colLength + 1];                       // 这里记得要 + 1，方便留出额外的一位给 0。

        for (int row = 0; row < rowLength; row++) {
            Stack<Integer> stack = new Stack<>();

            for (int col = 0; col <= colLength; col++) {            // 加的
                if (col < colLength && matrix[row][col] == '1') {
                    heigh[col] += 1;
                } else {
                    heigh[col] = 0;
                }
            }

            // 这里的就跟84的一模一样。
            for (int col = 0; col <= colLength; col++) {
                if (stack.isEmpty() || heigh[col] > heigh[stack.peek()]) {
                    stack.push(col);
                } else {
                    int currTop = stack.pop();
                    max = Math.max(max, heigh[currTop] * (stack.isEmpty() ? col : col - stack.peek() - 1)); // 这里是重点
                    col--;
                }
            }
        }
        return max;
    }
}
