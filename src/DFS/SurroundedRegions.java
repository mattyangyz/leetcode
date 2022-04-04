package DFS;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border,
 * which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * <p>
 * <p>
 * 思路： 遍历第一行最后一行 第一列最后一列找到O，然后进行dfs。
 * 边界都遍历完了， 再出现O的话，就全部都是被X包围的 也就是最后要变成X的。
 * <p>
 * <p>
 * 要巧妙地避开以下死循环
 * <p>
 * X 1 X X
 * X 1 1 X    -> 图 1
 * X X 1 X
 * X X 1 X
 */
public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++){          // 遍历边上，把边上全部能够到的都变为1， 这样剩下的内陆部分只要是'O'的就可以全部变为'X'
            for(int j = 0; j < cols; j++){      // 只需要这里用dfs就够了，里面不需要！
                if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 注意这里必须是 != O, 不能是 == 'X'， 不然的话遇到上面图1的情况会行程死循环
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }
}
