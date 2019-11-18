package MathRelated;


/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * <p>
 * <p>
 * <p>
 * Nice solution, but, as many others, I didn't get the line if ((newResult - tail) / 10 != result).
 * <p>
 * We're interested on what happens when an integer overflows. Well, it is rolled over. Practically speaking, if you would try
 * <p>
 * public static void main(String[] args) {
 * int rollMeOver= Integer.MAX_VALUE + 1;
 * System.out.println(rollMeOver);
 * }
 * You will get as an output -2147483648 which represents the lowest value for an integer (Integer.MIN_VALUE).
 * <p>
 * Thus, in our problem, if newResult is going to overflow we are sure that newResult / 10 != result
 * (this is the reason that @Inception_wzd said that we don't need to subtract the tail first because by
 * / 10 we are already losing the last digit).
 * <p>
 * By the way, the same thing happens for the underflow.
 * <p>
 * public static void main(String[] args) {
 * int rollMeOver= Integer.MIN_VALUE - 1;
 * System.out.println(rollMeOver);
 * }
 * This is going to output the Integer.MAX_VALUE which is 2147483647 .
 * <p>
 * Hope it helps!
 * <p>
 * Good luck! :D
 */
public class ReverseInteger {

    public static int reverse(int x) {

        int result = 0;

        while (x != 0) {

            int digit = x % 10;
            int newResult = result * 10 + digit;

            if (newResult / 10 != result) {
                return 0;
            }
            result = newResult;
            x /= 10;
        }
        return result;
    }
}
