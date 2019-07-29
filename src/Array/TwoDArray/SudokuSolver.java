package Array.TwoDArray;


/**
 *
 *
 * DFS
 *
 *
 * 重点 理解 临近的九个是怎样得出来的 -> (3 * row / 3) and (3 * col / 3) 算出 属于哪个 cube， 然后在那个
 * cube开始得坐标那里开始 i/3 -> row, i%3 -> col的一个位移。cube是每九个每九个的cube， 左上第一， 右下第九。
 *
 * 理解最后为什么要return true， 是因为只剩下一个的时候9 * 9的时候， 如果不是空的（已经有number的） 就会返回true，
 * 如果是空的， 就会填上然后从if (solve(board)) 返回true
 *
 * if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] != '.' &&
 *                     board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * Empty cells are indicated by the character '.'.
 *
 *
 * A sudoku puzzle...
 *
 *
 * ...and its solution numbers marked in red.
 *
 * Note:
 *
 * The given board contain only digits 1-9 and the character '.'.
 * You may assume that the given Sudoku puzzle will have a single unique solution.
 * The given board size is always 9x9.
 *
 */


public class SudokuSolver {

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    public static boolean solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.'){
                    for (char c = '1'; c <= '9'; c++) {     // trail, try one through 9
                        if(isValid(board, i, j, c)) {
                            board[i][j] = c;                // put c for this cell

                            if (solve(board)) {
                                return true;                // if it's the solution return true
                            } else {
                                board[i][j] = '.';          // otherwise go back
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + (i / 3)][3 * (col / 3) + (i % 3)] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
    }
}
