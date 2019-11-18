package DP;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 思路: 由左边到右边， 然后向两边扩散 根据基数偶数这样去扩散
 */

public class LongestPalindromicSubstring {

    int lowIndex = 0;
    int max = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() < 2){
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }

        return s.substring(lowIndex, lowIndex + max);
    }

    private void helper(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 到这里的时候其实已经超过左边跟右边 所以需要用 -1 +1 去调整
        if (right - left - 1 > max) {        // 这里要注意是 - 1
            max = right - left - 1;
            lowIndex = left + 1;            // 这里是 + 1
        }
    }

}
