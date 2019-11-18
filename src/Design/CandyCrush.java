package Design;

/**
 * https://leetcode.com/problems/candy-crush/
 * This question is about implementing a basic elimination algorithm for Candy Crush.
 * <p>
 * Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
 * <p>
 * If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
 * After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
 * After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
 * If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
 * You need to perform the above rules until the board becomes stable, then return the current board.
 * <p>
 * 思路: https://leetcode.com/problems/candy-crush/discuss/113914/15-ms-Short-Java-Solution-Mark-crush-with-negative-value
 */
public class CandyCrush {

    public int[][] candyCrush(int[][] board) {

        int rowLength = board.length;
        int colLength = board[0].length;

        boolean found = true;

        while (found) {
            found = false;
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < colLength; j++) {
                    int value = Math.abs(board[i][j]);
                    if (value == 0) {
                        continue;
                    }
                    if (j < colLength - 2 && Math.abs(board[i][j + 1]) == value && Math.abs(board[i][j + 2]) == value) {
                        found = true;
                        int index = j;
                        while (index < colLength && Math.abs(board[i][index]) == value) {
                            board[i][index] = -value;
                            index++;
                        }
                    }
                    if (i < rowLength - 2 && Math.abs(board[i + 1][j]) == value && Math.abs(board[i + 2][j]) == value) {
                        found = true;
                        int index = i;
                        while (index < rowLength && Math.abs(board[index][j]) == value) {
                            board[index][j] = -value;
                            index++;
                        }
                    }
                }
            }
            if (found) {    // move positive values to the bottom, then set the rest to 0
                for (int j = 0; j < colLength; j++) {
                    int storeIndex = rowLength - 1;
                    for (int i = rowLength - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {                      // todo: 理解 这里是把负数的那些都用正数去取代了
                            board[storeIndex][j] = board[i][j];
                            storeIndex--;
                        }
                    }
                    for (int k = storeIndex; k >= 0; k--) {
                        board[k][j] = 0;
                    }
                }
            }
        }
        return board;
    }
}
