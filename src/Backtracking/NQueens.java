package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        if (n <= 0) {
            return res;
        }
        helper(res, new int[n], 0);
        return res;
    }

    // queens queens里面每个index的value代表queens放在了哪一个列上
    public void helper(List<List<String>> res, int[] queens, int pos) {
        if (pos == queens.length) {
            addSolution(res, queens);
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

    public void addSolution(List<List<String>> res, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {                                   // 对于每一row
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {                               // 对于每个column
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
