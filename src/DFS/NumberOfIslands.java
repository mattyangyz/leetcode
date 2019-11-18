package DFS;

/**
 * int[3][4]  A  =  {  {  1,  0, 12, -1 },
 * {  7, -3,  2,  5 },
 * { -5, -2,  2, -9 }
 * };
 * <p>
 * new int[0][6]; INVALID
 * <p>
 * grid.length check int[size] -> row size
 * grid[0].length checks int[0][size] -> column size
 * <p>
 * 重点 是 i = 0, j = 0 而不是 i = 0, j = i + 1
 * <p>
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */


public class NumberOfIslands {

    private int n;
    private int m;


    public int numIsland(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = 0;
        DFSMarking(grid, i - 1, j);
        DFSMarking(grid, i + 1, j);
        DFSMarking(grid, i, j - 1);
        DFSMarking(grid, i, j + 1);

    }
}
