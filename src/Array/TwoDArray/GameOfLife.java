package Array.TwoDArray;


/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population. 01 -> 01
 * Any live cell with two or three live neighbors lives on to the next generation.          01 -> 11  (need to take care)
 * Any live cell with more than three live neighbors dies, as if by over-population..       01 -> 01
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction. 00 -> 10 (need to take care)
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],               // 这里是i - 1
 * [0,1,1],               // 这里是 i
 * [0,1,0]                // 这里是i + 1
 * ]
 * <p>
 * <p>
 * next  current
 * 1    0
 * 0    1   -> & 01的话就能知道现在的状态，不care next的状态
 * 1    1
 * <p>
 * <p>
 * 00
 * 01   这都是死亡的状态，但是我们不需要管。因为next默认为零了，shift的话 会变成 00
 * <p>
 * <p>
 * 时间复杂度： O(m * n)
 * space: O(1)
 */

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);
                if (board[i][j] == 1) {
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;           // 01变成11
                    }
                } else if (count == 3) {            // 原本是死细胞 但周边有三个， 所以变成活细胞
                    board[i][j] += 2;               // 00变成10
                }
            }
        }

        for (int i = 0; i < m; i++) {               //进行一个右边的移位
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {//判断周围有多少的存活
        int count = 0;

        for (int row = Math.max(0, i - 1); row <= Math.min(i + 1, board.length - 1); row++) { // 用max跟min是防止越界的问题
            for (int col = Math.max(0, j - 1); col <= Math.min(j + 1, board[0].length - 1); col++) {
                if (row == i && col == j) {
                    continue;
                }
                if ((board[row][col] & 1) == 1) {         // 如果变化后是 10 或 11的话， 我们 & 01 的话就能知道当前的状态
                    count++;
                }
            }
        }
        return count;
    }
}
