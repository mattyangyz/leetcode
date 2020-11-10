package PriorityQueue;

import java.util.PriorityQueue;


/**
 * https://www.youtube.com/watch?v=ZEgoEf8HGKI
 * <p>
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the volume of water it is able to trap after raining.
 * <p>
 * Example:
 * <p>
 * Given the following 3x6 height map:
 * [
 * [1,4,3,1,3,2],
 * [3,2,1,3,2,4],
 * [2,3,3,2,3,1]
 * ]
 * <p>
 * Return 4.
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 110
 * 0 <= heightMap[i][j] <= 20000
 * <p>
 * 思路: 从边边开始，然后走四边。如果不是边上的cell而且没有visit过的话，就看能否加到res里面，同时要把这个cell放到pq里面。
 * 之所以可以立马加是因为 如果边的cell是2，现在curr cell是1，那么这个curr cell肯定能被包住装水的，不存在情况说遇到比边cell(2)
 * 更小的cell，因为如果遇到的话那个比2小的边cell会被先执行(根据pq的性质)
 * <p>
 * <p>
 * // 注意这里肯定可以先处理边上的3，然后2，然后1， 不用担心到达2那里能否被装满的问题，因为用的是PQ，所有当poll出来3然后处理
 * // 四个边到2的时候 肯定知道所有的edge都不会比3小的了， 就算上方有1也不用担心
 * [
 * [5,5,5]
 * [5,1,5]
 * [5,2,5]
 * [5,3,5]
 * ]
 */

public class TrappingRainWaterII {

    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        public Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }

        public int compareTo(Cell otherCell) {
            if (this.height == otherCell.height) return 0;
            if (this.height < otherCell.height) return -1;
            return 1;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        if (heightMap.length < 1) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];

        // 先把四个边放到queue中
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        // 先把四个边放到queue中
        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }

        // 然后从小的开始处理
        int res = 0;
        while (!heap.isEmpty()) {
            Cell cur = heap.poll();
            int row = cur.row, col = cur.col, h = cur.height;

            for (int[] d : dirs) {
                int r = d[0] + row;
                int c = d[1] + col;

                if (r > 0 && r < m - 1 && c > 0 && c < n - 1 &&
                        !visited[r][c]) {
                    visited[r][c] = true;

                    res += Math.max(0, h - heightMap[r][c]);
                    heap.offer(new Cell(r, c, Math.max(h, heightMap[r][c])));
                }
            }
        }

        return res;
    }
}
