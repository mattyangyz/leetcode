package StringRelated;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store
 * integers within the 32-bit signed integer range: [−231,  231 − 1].
 * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * <p>
 * <p>
 * https://leetcode.com/problems/string-to-integer-atoi/discuss/4643/Java-Solution-with-4-steps-explanations
 * <p>
 * Overflow explanation: Integer.MAX_VALUE = 2147483647 and Integer.MIN_VALUE = -2147483648 is the largest/smallest value that an int primitive can contain.
 * <p>
 * // todo 这个是关键
 * Let's simplify this problem. Suppose str1 = " -a649b ", st2 = " a652b ", max = 647, min = -648.
 * So if atoi(str) > 647 || atoi(str) < -648 atoi will overflow.
 * In other words, when we've parsed num == 64 and the next char is also digit,
 * max / min can directly be returned if the next digit >= 8; or we've parsed num > 64, directly return too.
 */

public class StringToIntegerAtoi {

    public int myAtoi(String str) {

        int index = 0;
        int total = 0;
        int sign = 1;

        // check if empty string
        if (str.length() == 0) {
            return 0;
        }

        // remove white spaces from the string
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (index == str.length()) {
            return 0;
        }

        // get the sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // convert the actual number and make sure it's not overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // suppose 748 is max. If current total is 75 > 748 / 10, then enter the loop.
            // also if current is 74, then current digit is greater than 8 then enter.
            if (sign == 1 && (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) { // 这里是关键
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 + 1 < digit)) { // 这里是关键
                return Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}
