package Array.TwoDArray;

import java.util.HashSet;


// TODO NOT YET, this is incorrect.
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {

            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !rows.add(board[j][i])){
                    return false;
                }

                for (int k = 0; k < 9; k++) {

                    if(board[i * (i / 3) + k / 3][j * (j / 3) + k / 3] != '.' &&
                    !cube.add(board[i * (i / 3) + k / 3][j * (j / 3) + k / 3])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
