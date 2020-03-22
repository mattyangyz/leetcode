package DP.TwoDArrayRepresentsPalindrome;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * 思路: 一个二维数组 代表从 i到j是否palindromic。 必须从右下角开始，因为memo[i+1][j-1]这个的使用。
 */

public class PalindromicSubstrings {

    public static int countSubstrings(String s) {

        int len = s.length();
        boolean[][] memo = new boolean[len][len];

        int count = 0;
        for (int i = len - 1; i >= 0; i--) {        // 必须从右下角开始
            for (int j = len - 1; j >= i; j--) {          // 到达到i，也就是对角线就行了 不需要过去对角线的另外一边。
                if (i == j) {                         // 对角线，代表这个字母自己 这肯定是pal
                    memo[i][j] = true;
                } else if (j - i == 1) {                // 只有两个字母
                    memo[i][j] = s.charAt(i) == s.charAt(j);
                } else {                               // 多于两个字母
                    memo[i][j] = s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]; // bottom left
                }
                if (memo[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
