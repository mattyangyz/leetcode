package DP_Hard;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * <p>
 * 思路: backtracking逐一对比然后
 */

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }

        // s跟p的第一位相同，或者p的第一位是个*
        boolean firstMatch = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // use first char 0 times || use first char multiple times 可以考虑 -> s = aab, p = c*a*b 这种情况
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            //  这是没有星的情况， 就逐一往后比对就行
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static boolean isMatchDp(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; // 表示长度为i 和 j的string是否匹配。
        dp[0][0] = true;

        for (int i = 2; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                // 这里不能直接set true， 试想 s = a, p = ab*a 这种情况。 这么做是因为 s = aab, p = c*a*b这种情况
                dp[0][i] = dp[0][i - 2];    // 这里s的长度是0。此时看的是p能否跟s的空串相匹配
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];    // 继承之前的传递性，如果之前不匹配的 那么现在这里也不会匹配
                } else if (pc == '*') {
                    if (dp[i][j - 2]) {  // not use preceding char, i 是一样的长度 是 j 少了两个。譬如 s=aa p=ab*a 那么这时候这个b*可以选择为不用 直接去在第一个a那里的结果就行
                        dp[i][j] = true;
                    }
                    // 这里看是否重复了多次, sc == p.charAt(i-2) 是看当前字符是否跟*前的字符一样
                    else if (sc == p.charAt(j - 2) || p.charAt(j - 2) == '.') { // 看sc是否等于*前面的字符
                        dp[i][j] = dp[i - 1][j]; // 这里假设它用了一次，如果用多于一次 这个是可以transitive的 这个value会pass on
                    }
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 1. p.charAt(j) == s.charAt(i) -> 直接取前面的结果 dp[i][j] = dp[i-1][j-1]
     * 2. if p.charAt(j) == '.' 直接取前面的结果 dp[i][j] = dp[i-1][j-1]
     * 3. if p.char(j) == '*'
     * here are two sub conditions
     * 1. if p.charAt(j-1) != s.charAt(i) dp[i][j] = dp[i][j-2] // in this case a* only counts as empty
     * 2. if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.'
     * dp[i][j] = dp[i][j-1] // in this case a* counts as single a      1."aa" 2."a*" dp[i][j-1] 是看第一个里面的第二个a是否跟*前面的匹配
     * dp[i][j] = dp[i-1][j] // in this case a* counts as smultiple a
     * dp[i][j] = dp[i][j-2] // in this case a* counts as empty
     */

    public static boolean isMatchCspiration(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // dp[i+1][j] a* counts as single a       dp[i][j+1] in this case a* counts as multiple a          dp[i+1][j-1] a* counts as empty
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
