package Backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * 思路: 跟NQueens一模一样。
 */

public class NQueensII {

    int count = 0;

    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if (n <= 0) {
            return 0;
        }
        helper(res, new int[n], 0);
        return count;
    }

    // queens queens里面每个index的value代表queens放在了哪一个列上
    public void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            count++;
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[pos] = i;
            if (isValid(queens, pos)) {
                helper(res, queens, pos + 1);                                   // 每一个row去处理，pos + 1代表下一row
            }
        }
    }

    public boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) {                                         // 判断queens时候在同一column上
                return false;
            } else if (Math.abs(queens[pos] - queens[i]) == Math.abs(i - pos)) {    // 是否在对角线上, 重点
                return false;
            }
        }
        return true;
    }
}
