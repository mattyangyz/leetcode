//package Array.TwoDArray;
//
///** NOT YET. 非常难
// *
// * Given two sparse matrices A and B, return the result of AB.
// *
// * You may assume that A's column number is equal to B's row number.
// *
// * Example:
// *
// * Input:
// *
// * A = [
// *   [ 1, 0, 0],
// *   [-1, 0, 3]
// * ]
// *
// * B = [
// *   [ 7, 0, 0 ],
// *   [ 0, 0, 0 ],
// *   [ 0, 0, 1 ]
// * ]
// *
// * Output:
// *         a b c       A B C
// *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |         -> a的列数必须等于b的行数
// * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
// *                   | 0 0 1 |
// *
// */
//
//public class SparseMatrixMultiplication {
//
//    public int[][] multiply(int[][] A, int[][] B) {
//
//        int m = A.length;
//        int n = A[0].length;
//
//        int nB = B[0].length;
//        int[][] res = new int[m][nB];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (A[i][j] != 0) {
//                    for (int k = 0; k < nB; k++) {
//                        res[i][k] += A[i][j] * B[]
//                    }
//                }
//            }
//        }
//    }
//}
