package Array.TwoDArray;

/**
 * 要review 而且有更好的优化解
 * <p>
 * Given two sparse matrices A and B, return the result of AB.
 * <p>
 * You may assume that A's column number is equal to B's row number.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * A = [
 * [ 1, 0, 0],
 * [-1, 0, 3]
 * ]
 * <p>
 * B = [
 * [ 7, 0, 0 ],
 * [ 0, 0, 0 ],
 * [ 0, 0, 1 ]
 * ]
 * <p>
 * Output:
 * a b c       A B C
 * |  1 0 0 |   | 7 0 0 |   |  7 0 0 |         -> a的列数必须等于b的行数 2x3 * 3*3 = 2*3
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 * | 0 0 1 |
 * <p>
 * <p>
 * 思路: a) Originally, the normal way to calculate the multiplication of two metrics A, and B is as follow:
 * We take the the all values from the first line of A, and all values from the first column of B,
 * and multiply the corresponding values and sum them up, the final sum is the value for the location of first
 * column and first row in final result matrix. Similarly, the value at [ i ][ j ] of result matrix C, which is C[ i ][ j ] is calculated as:
 * <p>
 * C[ i ][ j ] = A[ i ][0]*B[0][j] + A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... A[i][K]*B[K][j]
 * ( which is the sum of each multiplication of corresponding K values from row i of A and K values from column j of B )
 * The Key is: if we calculate it this way, we finishing calculating the final value for the result matrix at once
 * <p>
 * https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76151/54ms-Detailed-Summary-of-Easiest-JAVA-solutions-Beating-99.9 优化
 */

public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {

        int m = A.length;
        int n = A[0].length;

        int nB = B[0].length;
        int[][] res = new int[m][nB];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nB; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
