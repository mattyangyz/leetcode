package Array.GoingFromLeftThenRight;


/**
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * Note:
 * <p>
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 * <p>
 * <p>
 * <p>
 * <p>
 * 思路: 左边跑一趟，右边跑一趟。
 * <p>
 * "loveleetcode" "e"
 * 1. put 0 at all position equals to e, and max at all other position
 * we will get [max, max, max, 0, max, 0, 0, max, max, max, max, 0]
 * 2. scan from left to right, if =max, skip, else dist[i+1] = Math.min(dp[i] + 1, dp[i+1]),
 * we can get [max, max, max, 0, 1, 0, 0, 1, 2, 3, 4, 0]
 * 3. scan from right to left, use dp[i-1] = Math.min(dp[i] + 1, dp[i-1])
 * we will get[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */


public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] prevResult = new int[n];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                continue;
            }
            prevResult[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n - 1; i++) {
            if (prevResult[i] == Integer.MAX_VALUE) {
                continue;
            } else {
                prevResult[i + 1] = Math.min(prevResult[i] + 1, prevResult[i + 1]);
            }
        }

        for (int i = n - 1; i > 0; i--) {
            prevResult[i - 1] = Math.min(prevResult[i - 1], prevResult[i] + 1);
        }
        return prevResult;
    }
}
