package ModeAndDivideIndexCalculation;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolverWithoutModAndDivide {

    Set<String> seen = new HashSet<>();

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        // pre process
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    seen.add(board[i][j] + " in col " + j);
                    seen.add(board[i][j] + " in row " + i);
                    seen.add(board[i][j] + " in cube " + i / 3 + "." + j / 3);
                }
            }
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {     // trail, try one through 9
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;                // put c for this cell

                            seen.add(c + " in col " + j);
                            seen.add(c + " in row " + i);
                            seen.add(c + " in cube " + i / 3 + "." + j / 3);
                            if (solve(board)) {
                                return true;                // if it's the solution return true
                            }
                            else {
                                seen.remove(c + " in col " + j);
                                seen.remove(c + " in row " + i);
                                seen.remove(c + " in cube " + i / 3 + "." + j / 3);
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

    private boolean isValid(char[][] board, int row, int col, char c) {
        if(seen.contains(c + " in col " + col)){
            return false;
        }
        if(seen.contains(c + " in row " + row)){
            return false;
        }
        if(seen.contains(c + " in cube " + row / 3 + "." + col / 3)){
            return false;
        }
        return true;
    }
}
