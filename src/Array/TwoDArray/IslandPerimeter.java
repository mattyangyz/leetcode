package Array.TwoDArray;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 * <p>
 * <p>
 * 思路: 普通的遍历 然后 （4 * 岛的数目 - 邻居 * 2）
 */

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int nei = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; i++) {
                if (grid[i][j] == 1) {                                  // 计算有多少个岛
                    islands++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {   // 计算有多少邻居
                        nei++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {// 计算有多少邻居
                        nei++;
                    }
                }
            }
        }
        return islands * 4 - nei * 2;
    }
}
