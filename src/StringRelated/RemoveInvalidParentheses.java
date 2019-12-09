package StringRelated;

import java.util.ArrayList;
import java.util.List;

/**
 * 非常难 ！！难！！ 用了一天已经！
 * <p>
 * 思路: 扫描整个字符串， 一旦发现左括号比右括号多 删除一个右括号
 * 1） 删除哪一个右括号？
 * 2） 如何避免重复
 * 3） 如果左括号比右括号的数量多，如何处理
 * 4） 怎么去判断左右括号哪个多
 */


public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'{', '}'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {

        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                count++;
            }
            if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {           // ( 多于 ) 的情况，是valid的， 因为后面有可能会遇到更多的 ).
                continue;
            }
            for (int j = last_j; j <= i; j++) {                         // last_j 是 last removal index.
                // 现在的这个是右括号 && )( 这种情况  || 前面一个不是右括号
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;    // 这个一定要加
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else {

        }
    }
}
