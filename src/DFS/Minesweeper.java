package DFS;

/**
 *
 *  Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 * If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 *
 * 思路: we should onl recursively reveal adjacent cells if the current cell is to revel 'b'
 */


// 思路，从click那里开始，然后找出身边有多少个雷，需要写一个findMine的方法。如果身边的八个cell都没有雷的话，
// 就逐一进行同样的dfs call。 注意只有mine == 0 也就是B的时候才进行recursively dfs的call。

public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {   // 如果当前是雷的话，直接返回。
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int mines = findMines(board, x, y);

        if (mines == 0) {
            board[x][y] = 'B';
            for (int i = -1; i <= 1; i++) {         // 不是全局的，只是这个被选中的x和y的附近九个进行一个局部的dfs 而且是这个x，y周围的雷数
                for (int j = -1; j <= 1; j++) {     // 是零的时候，才进行一个dfs的如果不是零那就结束。
                    dfs(board, x + i, y + j);
                }
            }
        } else {
            board[x][y] = (char) ('0' + mines);
        }

    }

    public int findMines(char[][] board, int x, int y) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int x1 = x + i;
                int y1 = y + j;
                if (x1 < 0 || y1 < 0 || x1 >= board.length || y1 >= board[0].length) {
                    continue;
                }
                if (board[x1][y1] == 'M') {
                    count++;
                }
            }
        }
        return count;
    }
}
