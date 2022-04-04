package Design.TicTacToe_IMPORTANT;


// this is the opt version of ticTacToe
// 这个做法就不valid 现在这个move放到已经有的cell上这个情况。因为题目已经表明
// A move is guaranteed to be valid and is placed on an empty block.
public class TicTacToeOpt {

    private int[] rows;
    private int[] cols;
    private int diag;
    private int antiDiag;

    public TicTacToeOpt(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        antiDiag = 0;
    }

    public int move(int row, int col, int player) {

        /* player 1 is 1, player 2 is -1 */
        int addMark = player == 1 ? 1 : -1;

        /* update the current move onto the corresponding row and column */
        rows[row] += addMark;
        cols[col] += addMark;

        if (row == col) {
            diag += addMark;
        }

        if (row + col == rows.length - 1) {     // 要知道怎么判断是否对角线
            antiDiag += addMark;
        }

        /* when sum of the current certain row or column is n or -n
            we know a player has won */
        int n = rows.length;
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diag) == n ||
                Math.abs(antiDiag) == n) {
            return player;
        }
        return 0;
    }
}
