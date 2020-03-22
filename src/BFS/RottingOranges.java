package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * 思路: 用BFS去做。 事前要统计有多少的total 1和2。把rotten的数量在每次BFS的时候increment地sum出来， 一旦rotten的数量等于total,
 * 那就证明完成计算了。
 */


public class RottingOranges {

    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new LinkedList<>();
        int total = 0;
        int rotten = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        while (!queue.isEmpty() && rotten < total) {
            int size = queue.size();

            rotten += size;                         // 这里是关键
            if (rotten == total) {                  // 这里是关键
                return time;
            }

            time++;

            for (int i = 0; i < size; i++) {
                Position p = queue.peek();
                if (p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    queue.offer(new Position((p.x + 1), p.y));
                }

                if (p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    queue.offer(new Position((p.x - 1), p.y));
                }

                if (p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    queue.offer(new Position((p.x), p.y + 1));
                }

                if (p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    queue.offer(new Position((p.x), p.y - 1));
                }
                queue.poll();
            }
        }
        return -1;
    }
}
