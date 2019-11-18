package Array.TwoDArray;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class SpiralMatrixII {

    public int[][] spiralOrderII(int n) {

        int[][] matrix = new int[n][n];

        if (matrix.length == 0) {
            return matrix;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        int num = 1;

        while (true) {
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = num++;
            }
            rowBegin++;
            if (rowBegin > rowEnd) break;

            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = num++;
            }
            colEnd--;
            if (colBegin > colEnd) break;

            for (int j = colEnd; j >= colBegin; j--) {
                matrix[rowEnd][j] = num++;
            }
            rowEnd--;
            if (rowBegin > rowEnd) break;

            for (int j = rowEnd; j >= rowBegin; j--) {
                matrix[j][colBegin] = num++;
            }
            colBegin++;
            if (colBegin > colEnd) break;
        }
        return matrix;
    }
}
