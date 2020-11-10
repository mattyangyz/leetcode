package DP_Hard;


/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 * <p>
 * <p>
 * 0, 1, 2, 3, 4
 * <p>
 * b, b, b, a, b
 * <p>
 * i is the left index, j is the right index
 * <p>
 * if s[i] == s[j], then M[i][j] = 2 + M[i+1][j-1]
 * if s[i] != s[j], then M[i][j] = max(M[i+1][j], M[i][j-1])
 * <p>
 * <p>
 * <p>
 * M, 0, 1, 2, 3, 4
 * ,
 * 0  X  X  X  X  X
 * ,
 * 1  X  X  *  ^  X
 * ,
 * 2  X  X  *  *  X
 * ,
 * 3  X  X  X  X  X
 * ,
 * 4  X  X  X  X  X
 * <p>
 * ^表示当前M[1][3], 需要用到的值是*表示出来
 * <p>
 * <p>
 * dp[i][j]: the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
 * State transition:
 * dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
 * otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
 * Initialization: dp[i][i] = 1
 * <p>
 * <p>
 * https://www.laioffer.com/en/videos/2018-03-14-516-longest-palindromic-subsequence/
 */


public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int length = s.length();
        int[][] matrix = new int[length][length];

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {                            // take the left-down value
                    matrix[i][j] = matrix[i + 1][j - 1] + 2;
                } else {
                    matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j - 1]);    // take the left or down value
                }

            }
        }
        return matrix[0][length - 1];
    }
}
