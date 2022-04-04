package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;


/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * Example 2:
 * <p>
 * Input: 14
 * Output: false
 * <p>
 * 思路: 这题其实就是能否找到一个整数相乘等于num，属于找确定数字的一类题。
 */

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        long mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}