package MathRelated;

/**
 * Implement ]pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 *
 * 思路: 8^7 -> 8^3 -> 8^1 -> 8^0 === 1 -> 1 * 1 * 8 -> 8 * 8 * 8 -> 8^3 * 8^3 * 8 这个是整个流程， 需要理解。
 *
 */

public class PowX {

    public static void main(String[] args){
        myPow(2, 3);
    }

    public static double myPow(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;           // 这里是关键
        }
    }
}
