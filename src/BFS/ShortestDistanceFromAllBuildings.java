package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
 * <p>
 * Each 0 marks an empty land which you can pass by freely.
 * Each 1 marks a building which you cannot pass through.
 * Each 2 marks an obstacle which you cannot pass through.
 * Example:
 * <p>
 * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
 * <p>
 * 1 - 0 - 2 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * <p>
 * Output: 7
 * <p>
 * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
 * the point (1,2) is an ideal empty land to build a house, as the total
 * travel distance of 3+3+1=7 is minimal. So return 7.
 * Note:
 * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
 * <p>
 * <p>
 * 思路: 见iPad。 从1开始走，遇到0的话就开始计算。两个array，一个记录有多少1可以走到这里，必须累加。第二个toHereDistance表示当前i j的总cost 这里必须也是累加
 * 包含之前的cost。
 * 没有优化的话run time: O(n^2)，优化后也是同样的时间 只是比没有优化要快一点.
 */

public class ShortestDistanceFromAllBuildings {

    private int[] rowDir = {0, 0, 1, -1};
    private int[] colDir = {1, -1, 0, 0};

    public int shortestDistance(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return -1;
        }

        // 有多少个1可以走到这里。
        int[][] howManyCanReach = new int[grid.length][grid[0].length];
        int[][] toHereDistance = new int[grid.length][grid[0].length];

        int totalBuilding = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {  // 历遍整个array,只有1的时候才进入到bfs
                if (grid[i][j] == 1) {
                    totalBuilding++;
                    if (!bfs(grid, i, j, howManyCanReach, toHereDistance)) {
                        return -1;
                    }
                }
            }
        }


        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {


                if (howManyCanReach[i][j] == totalBuilding && toHereDistance[i][j] < minDistance) {
                    minDistance = toHereDistance[i][j];
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private boolean bfs(int[][] grid, int row, int col, int[][] howManyCanReach, int[][] toHereDistance) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int distance = 0;
        queue.offer(new int[]{row, col});
        visited[row][col] = true;                                       // 每一次bfs都必须要有一个新的visited

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = cur[0] + rowDir[k];
                    int newCol = cur[1] + colDir[k];

                    if (!isValid(grid, newRow, newCol, visited)) {
                        continue;
                    }
                    if (grid[newRow][newCol] == 0) {
                        queue.offer(new int[]{newRow, newCol});             // 算是优化
                        toHereDistance[newRow][newCol] += distance;         // 这里是加上之前的1 走到的distance
                        howManyCanReach[newRow][newCol]++;                  //
                    }
                    visited[newRow][newCol] = true;                         // 遇见 1 的话也会mark成visited，方面下面进行一个判断

                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {                      // 上面指的下面，是这里！！！！ 算是优化
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (grid[row][col] == 2) {                                          // 这里就算是遇到 1 的也算是valid的。算是优化
            return false;
        }
        return true;
    }

}
