package Design.TicTacToe;


/**
 * Design a Tic-tac-toe game that is played between two players on a n x n grid.
 * <p>
 * You may assume the following rules:
 * <p>
 * A move is guaranteed to be valid and is placed on an empty block.
 * Once a winning condition is reached, no more moves is allowed.
 * A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 * Example:
 * Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
 * <p>
 * TicTacToe toe = new TicTacToe(3);
 * <p>
 * toe.move(0, 0, 1); -> Returns 0 (no one wins)
 * |X| | |
 * | | | |    // Player 1 makes a move at (0, 0).
 * | | | |
 * <p>
 * toe.move(0, 2, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 2 makes a move at (0, 2).
 * | | | |
 * <p>
 * toe.move(2, 2, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | | | |    // Player 1 makes a move at (2, 2).
 * | | |X|
 * <p>
 * toe.move(1, 1, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 2 makes a move at (1, 1).
 * | | |X|
 * <p>
 * toe.move(2, 0, 1); -> Returns 0 (no one wins)
 * |X| |O|
 * | |O| |    // Player 1 makes a move at (2, 0).
 * |X| |X|
 * <p>
 * toe.move(1, 0, 2); -> Returns 0 (no one wins)
 * |X| |O|
 * |O|O| |    // Player 2 makes a move at (1, 0).
 * |X| |X|
 * <p>
 * toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
 * |X| |O|
 * |O|O| |    // Player 1 makes a move at (2, 1).
 * |X|X|X|
 * Follow up:
 * Could you do better than O(n2) per move() operation?
 * <p>
 * <p>
 * 思路：
 * It is only the last step that triggers the win so we just need to check the row/col/diagonal where the last step/"cell" belongs to,
 * which means we don't really need to check all the rows/cols/diagonals for each move.
 * This will help us to get O(n) for each move instead of O(n^2)     ->    这个可以保证我们能够有O(N)
 */

// 这题的简单版本就是每一次move都判断一下row，col以及对角是否都是当前move的玩家的，如果是的话，就赢了。
// 进阶的版本是 最后一步才判断。
public class TicTacToe {

    int[][] grid;

    public TicTacToe(int n) {
        grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        if (row >= grid.length || col >= grid[0].length) {      // out of grid
            return 0;
        }

        if (grid[row][col] != 0) {                              // grid is used
            return 0;
        }
        grid[row][col] = player == 1 ? 1 : 2;

        if (checkVertivalWin(col, player)) {
            return player;
        }
        if (checkHorizontalWin(row, player)) {
            return player;
        }
        if (checkDiagonalWin(row, col, player)) {
            return player;
        }
        return 0;
    }

    private boolean checkVertivalWin(int col, int player) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkHorizontalWin(int row, int player) {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[row][i] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonalWin(int row, int col, int player) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }

        boolean topLeftToButtomRight = true;
        boolean topRightToButtomLeft = true;

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] != player) {
                topLeftToButtomRight = false;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid.length - i - 1] != player) {
                topRightToButtomLeft = false;
            }
        }
        return topLeftToButtomRight || topRightToButtomLeft;
    }
}
