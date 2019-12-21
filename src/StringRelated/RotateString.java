package StringRelated;

/**
 * We are given two strings, A and B.
 * <p>
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 * <p>
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 * <p>
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * <p>
 * 思路: 这道题给了我们两个字符串A和B，定义了一种偏移操作，以某一个位置将字符串A分为两截，
 * 并将两段调换位置，如果此时跟字符串B相等了，就说明字符串A可以通过偏移得到B。
 * 现在就是让我们判断是否存在这种偏移，那么最简单最暴力的方法就是遍历所有能将A分为两截的位置，
 * 然后用取子串的方法将A断开，交换顺序，再去跟B比较，如果相等，返回true即可，遍历结束后，返回false
 * <p>
 * runtime -> o(n^2) 因为substring是O(n)的。
 */

public class RotateString {

    public boolean rotateString(String A, String B) {

        for (int i = 0; i < A.length(); i++) {
            if ((A.substring(i, A.length() - 1) + A.substring(0, i)).equals(B)) {
                return true;
            }
        }
        return false;
    }
}
