package MathRelated;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * <p>
 * <p>
 * 思路: https://leetcode.com/problems/divide-two-integers/discuss/13397/Clean-Java-solution-with-some-comment.
 */

public class DivideTwoIntegers {

    public int divide(int divident, int divisor) {
        int sign = 1;
        if ((divident > 0 && divisor < 0) || (divident < 0 && divisor > 0)) {
            sign = -1;
        }

        long ldividend = Math.abs((long) divident);
        long ldivisor = Math.abs((long) divisor);

        if (ldivisor == 0) {                                              // edge case
            return Integer.MAX_VALUE;
        }
        if (ldividend < ldividend || ldividend == 0) {                  // edge case
            return 0;
        }

        long lres = divide(ldividend, ldivisor);
        int res = 0;
        if (lres > Integer.MAX_VALUE) {                                 // todo: 理解这里
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (sign == 1) {
                res = (int) lres;
            } else {
                res = (int) -res;
            }
        }
        return res;
    }

    public long divide(long ldividend, long ldivisor) {

        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {                          // because of this sum + sum, we need to use long.
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);    // why recursive again, think about 15 / 3

    }
}
