package DFS;


/**
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * <p>
 * 思路: 用DFS去做。
 *
 * Cache的作用是保存之前的结果，例如
 * [4, 3, 2]
 * [0, 4      -> 当走到上面example2的中间的2的时候，对于向上走 不需要重复走。只需要把上面的结果3拿下来就可以。
 */

// 这题的优化是存之前的结果，而且注意要用两个max，第一个max是全局的，第二个max是四个方向的max。
// 只要一个方向的cell是之前走过的，就能利用之前的结果。前提是curr的cell value要小于那个方向的。

// 从一个点开始，然后dfs，一边走一边update cache的value。同时要用一个prev的value知道当前的node相对应之前的value
// 是什么，如果现在的比之前的小 那就不需要走下去了。 而且如果当前的已经存在cache中，表明已经走过了 直接返回结果就行
// 在四个方向里面取最大的放到cache中，而且返回最大的那一个
public class longestIncreasingPathInAMatrix {

    public int longestIncreasingpath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];      // 把中间结果存起来，减少重复计算。

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int prev, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= prev) {    // 判断现在的值有没有比之前的大
            return 0;
        }
        if (cache[i][j] > 0) {
            return cache[i][j];
        }
        prev = matrix[i][j];
        int a = dfs(matrix, prev, i - 1, j, m, n, cache) + 1;
        int b = dfs(matrix, prev, i + 1, j, m, n, cache) + 1;
        int c = dfs(matrix, prev, i, j - 1, m, n, cache) + 1;
        int d = dfs(matrix, prev, i, j + 1, n, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;                                                  //注意这里必须要存回去结果
        return max;
    }
}
