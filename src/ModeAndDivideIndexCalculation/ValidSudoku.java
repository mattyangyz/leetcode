package ModeAndDivideIndexCalculation;

import java.util.HashSet;
import java.util.Set;


/**
 * Great solution!. Just trying to explain how to think about % and /. These two operators can be helpful for matrix traversal problems.
 * <p>
 * For a block traversal, it goes the following way.
 * <p>
 * 0,0, 0,1, 0,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
 * <p>
 * 1,0, 1,1, 1,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
 * <p>
 * 2,0, 2,1, 2,2; < --- 3 Horizontal Steps.
 * <p>
 * And so on...
 * But, the j iterates from 0 to 9.
 * <p>
 * But we need to stop after 3 horizontal steps, and go down 1 step vertical.
 * <p>
 * Use % for horizontal traversal. Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2,
 * and resets back. So this covers horizontal traversal for each block by 3 steps.
 * <p>
 * Use / for vertical traversal. Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
 * <p>
 * So far, for a given block, you can traverse the whole block using just j.
 * <p>
 * <p>
 * But because j is just 0 to 9, it will stay only first block. But to increment block, use i.
 * To move horizontally to next block, use % again : ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns.
 * Ie 0,0 is start of first block, second block is 0,3 (not 0,1);
 * <p>
 * Similarly, to move to next block vertically, use / and multiply by 3 as explained above. Hope this helps.
 *
 *
 *         # 0 => 0, 1 => 3, 2 => 6
 *         # 3 => 0, 4 => 3, 5 => 6
 *         # 6 => 0, 7 => 3, 8 => 6
 *         x = (i % 3) * 3
 *         # 0 => 0, 1 => 0, 2 => 0
 *         # 3 => 3, 4 => 3, 5 => 3
 *         # 6 => 6, 7 => 6, 8 => 6
 *
 *
 */

// https://www.youtube.com/watch?v=ceOLAY4XUOw&t=172s
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    int number = board[i][j] - '0';
                    if(!seen.add(number + " in col " + j)
                            || !seen.add(number + " in row " + i)
                            || !seen.add(number + " in col " + i / 3 + "." + j / 3)){
                        return false;
                    }

                }
            }
        }
        return true;
    }
}
