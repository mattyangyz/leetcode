package Backtracking;

import java.util.ArrayList;
import java.util.List;

// backtracking
// the key is to make sure that close parentheses do not go over the open parentheses.

/**
 * Given n pairs of parentheses, write a function to generate all combinations of
 * well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 用一个open， close，max的var去keep track括号的数量。必须先放(， 再放)。
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> ans, String curr, int open, int close, int max) {
        if (curr.length() == max * 2) {
            ans.add(curr);
            return;
        }
        if (open < max) {
            backtrack(ans, curr + "(", open + 1, close, max);
        }
        if(close < open){
            backtrack(ans, curr + ")", open, close + 1, max);
        }
    }
}
