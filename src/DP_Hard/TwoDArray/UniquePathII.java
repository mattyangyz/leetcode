package DP_Hard.TwoDArray;


/**
 * * More explanation:
 * * This is a typical 2D DP problem,
 * * we can store value in 2D DP array,
 * * but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] to update dp[i][j],
 * * we don't need to store the whole 2D table, but instead store value in an 1D array, and update data by using dp[j] = dp[j] + dp[j - 1],
 * * (where here dp[j] corresponding to the dp[i - 1][j]) and dp[j - 1] corresponding to the dp[i][j - 1] in the 2D array)
 * <p>
 * <p>
 * <p>
 * 63. Unique Paths II
 * Medium
 * <p>
 * 937
 * <p>
 * 145
 * <p>
 * Favorite
 * <p>
 * Share
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * <p>
 * 0, 0, 0        1, 1, 1
 * 0, 0, 0  dp -> 1, 2, 3   (这个是dp这个array如何变化的)
 * 1, 0, 0        0, 2, 5
 */

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //起点是障碍，直接返回 0
        if (grid[0][0] == 1) {
            return 0;
        }

        int[] dp = new int[n];

        int i = 0;

        //初始化第一行和 62 题不一样了
        //这里的话不是全部初始化 1 了，因为如果有障碍的话当前列和后边的列就都走不过了，初始化为 0
        for (; i < n; i++) {
            if (grid[0][i] == 1) {
                dp[i] = 0;
                break;
            } else {
                dp[i] = 1;
            }
        }

        //障碍后边的列全部初始化为 0
        for (; i < n; i++) {
            dp[i] = 0;
        }

        for (i = 1; i < m; i++) {

            //这里改为从 0 列开始了，因为 62 题中从 1 开始是因为第 0 列永远是 1 不需要更新
            //这里的话，如果第 0 列是障碍的话，需要更新为 0
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j != 0) {
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
