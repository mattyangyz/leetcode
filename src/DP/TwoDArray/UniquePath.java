package DP.TwoDArray;


/**
 * Dynamic Programming
 *
 * 1, 1, 1, 1
 * 1, 2, 3, 4
 * 1, 3, 6, 10
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

    public int uniquePathsOpt(int m, int n) {

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];

    }
}
