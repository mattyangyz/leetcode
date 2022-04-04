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
 *
 * Example:
 *
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
 * [0,1,1],               // 这里是 i     -> 这是对于每一个cell需要遍历的地方， 一共八个cell。
 * [0,1,0]                // 这里是i + 1
 * ]
 *
 * next  current
 * 1    0
 * 0    1   -> & 01的话就能知道现在的状态，不care next的状态
 * 1    1
 * 0    0
 * 0    1   这都是死亡的状态，但是我们不需要管。因为next默认为零了，shift的话 会变成 00
 *
 * 时间复杂度： O(m * n)
 * space: O(1)
 */

// 用两位数的binary number去表示现在以及下一个状态。当前状态里面 要考虑三种live的状态，一种dead的状态。
// 一个难点就是新的数字放上去了以后，怎么保证遍历到这个数字的时候得到之前的状态。这里需要考虑用到bit的运算。
//
public class GameOfLife {

    public static void main(String[] args){
        System.out.println(3 >>1);

    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbor(board, i, j);

                if (board[i][j] == 1) {             //或者 if((board[i][j] & 1) == 1) 也是可以的。
                    if (count == 2 || count == 3) {
                        board[i][j] += 2;           // 01变成11
                    }
                } else if (count == 3) {            // 原本是死细胞 但周边有三个， 所以变成活细胞
                    board[i][j] += 2;               // 00变成10
                }
            }
        }
        System.out.println(board);

        for (int i = 0; i < m; i++) {               //进行一个右边的移位
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >> 1;     // 这里或者 >>> 也是可以的。
            }
        }
    }

    private int countNeighbor(int[][] board, int i, int j) {
        int count = 0;
        int rowBegin = i - 1 < 0 ? 0 : i - 1;
        int rowEnd = i + 1 > board.length - 1 ? board.length - 1 : i + 1;
        int colBegin = j - 1 < 0 ? 0 : j - 1;
        int colEnd = j + 1 > board[0].length - 1 ? board[0].length - 1 : j + 1;

        for (int row = rowBegin; row <= rowEnd; row++) {
            for (int col = colBegin; col <= colEnd; col++) {
                if (row == i && col == j) {
                    continue;
                }
                if ((board[row][col] & 01) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
