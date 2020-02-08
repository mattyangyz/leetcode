package DFS;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 * <p>
 * 思路: 第一种解法关键是怎么update global max和single max。
 */

public class MaxAreaOfIsland {

    private int globalArea = 0;
    private int singleMax = 0;

    public int maxAreaOfIsland(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 && !visited[i][j]) {
                    findAreaHelper(grid, visited, i, j);
                    globalArea = Math.max(globalArea, singleMax);
                    singleMax = 0;
                }
            }
        }
        return globalArea;
    }

    private void findAreaHelper(int[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        singleMax += 1;

        findAreaHelper(grid, visited, i - 1, j);
        findAreaHelper(grid, visited, i + 1, j);
        findAreaHelper(grid, visited, i, j - 1);
        findAreaHelper(grid, visited, i, j + 1);

    }


    public int maxAreaOfIslandMoreConcise(int[][] grid) {

        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {

                    int area = depthFirstSearchHelper(grid, visited, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private int depthFirstSearchHelper(int[][] grid, boolean[][] visited, int i, int j) {
        if ((i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) || grid[i][j] != 1 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + depthFirstSearchHelper(grid, visited, i - 1, j) +
                depthFirstSearchHelper(grid, visited, i + 1, j) +
                depthFirstSearchHelper(grid, visited, i, j - 1) +
                depthFirstSearchHelper(grid, visited, i, j + 1);
    }


}
