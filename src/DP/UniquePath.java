package DP;


/**
 * Dynamic Programming
 *
 * The assumptions are
 *
 * When (n==0||m==0) the function always returns 1 since the robot
 * can't go left or up.
 * For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
 * Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
 *
 *
 *
 */

public class UniquePath {

    public int uniquePaths(int m, int n) {

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            res[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[n - 1][m - 1];
    }
}
