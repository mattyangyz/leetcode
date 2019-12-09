package StringRelated;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * <p>
 * Example 1:
 * <p>
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "dcbabcd"
 * <p>
 * 思路: 这题应该用KMP解法优化。
 * 下面这种解法的end是用来keep track end后面的那些element应该是被append的要。
 */

public class ShortestPalindrome {

    public String shorestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int end = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
