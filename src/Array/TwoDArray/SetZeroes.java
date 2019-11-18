package Array.TwoDArray;


/**
 * 思路
 * 1  1  2  0        1  1  0  0
 * 3  0  5  2   ->   0  0  5  2 ， then going down
 * 1  3  0  5        0  3  1  5
 * <p>
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * Follow up:
 * <p>
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] row_zeros = new boolean[row];
        boolean[] col_zeros = new boolean[col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (matrix[i][j] == 0) {
                    row_zeros[i] = true;
                    col_zeros[j] = true;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            if (row_zeros[i]) {
                setRowZeros(matrix, i);
            }
        }

        for (int i = 0; i < col; i++) {
            if (col_zeros[i]) {
                setColZeros(matrix, i);
            }
        }

    }

    private void setRowZeros(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColZeros(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public void setZeros(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        /**
         * 0  1  2  0                                                     0  0  0  0
         * 3  4  5  2   -> if here i starts from 0, then it will become   0  3  5  2 to do next;
         * 1  3  1  5                                                     0  3  1  5
         */

        for (int i = 1; i < matrix.length; i++) {           // this is starting from 1 NOT 0, cannot set the first row and first col here.
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
