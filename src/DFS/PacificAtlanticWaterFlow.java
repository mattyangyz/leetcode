package DFS;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * <p>
 * 题意: 数字代表洋流，大的洋流可以往小的那里流。求出所有的坐标，这些点既可以流去太平洋 也可以去大西洋。
 * <p>
 * 思路: 不同于一般的DFS。我们的DFS是从每一行每一列的点开始。
 * 1. 第一行第一列全部都是true 2. 判断上下左右(DFS)， 如果能走的话 判断大小 要是大于等于的话 这个邻居也是true.
 */

public class PacificAtlanticWaterFlow {

    int m = 0;
    int n = 0;

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) {
            return res;
        }
        n = matrix[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];


        for (int i = 0; i < m; i++) {       // 从第一行开始
            helper(matrix, pac, i, 0);
            helper(matrix, atl, i, n - 1);
        }
        for (int i = 0; i < n; i++) {       // 从第一列开始
            helper(matrix, pac, 0, i);
            helper(matrix, atl, m - 1, i);
        }

        for (int i = 0; i < m; i++) {       // 求既能流去太平洋和大西洋的洋流
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    List list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private void helper(int[][] matrix, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            // 邻居的洋流要比现在的小的话 就不能流 不进行DFS。
            if (x < 0 || y < 0 || x >= m || y >= n || isVisited[x][y] == true || matrix[i][j] > matrix[x][y]) {
                continue;
            }
            // 邻居的洋流要比现在的大于等于的话 就流，注意这里的逻辑。
            helper(matrix, isVisited, x, y);
        }
    }
}
