package DP.TwoDArrayRepresentsPalindrome;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * <p>
 * 思路: [][] isPalindrome 判断从i到j是否是回文。
 * [] cuts 存又len开始，往index 0的min cut数。必须是min的。
 * <p>
 * abcda -> s.char(i) ==  s.char(j) && isPalindrome[i + 1][j - 1]
 */

public class PalindromePartitioningII {

    public static int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrom = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {                    // i是substring的开头
            int min = len - i - 1;                              // i是substring开头的位置，len - i就等于substring 每个字母切的长度
            // 如果是banana i=2 6-2-1=3 nana 切三刀

            for (int j = len - 1; j >= i; j--) {                // j是substring的尾部
                if (i == j) {
                    isPalindrom[i][j] = true;
                } else if (j - i == 1) {
                    isPalindrom[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrom[i][j] = s.charAt(i) == s.charAt(j) && isPalindrom[i + 1][j - 1];
                }
                if (isPalindrom[i][j] == true) {
                    min = j == len - 1 ? 0 : Math.min(min, cuts[j + 1] + 1);         // 这是唯一一个跟PalindromicSubstrings不一样的地方。
                }
            }
            cuts[i] = min;
        }
        return cuts[0];
    }
}
