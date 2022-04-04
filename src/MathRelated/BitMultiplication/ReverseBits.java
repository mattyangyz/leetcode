package MathRelated.BitMultiplication;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
 * <p>
 * <p>
 * 思路: 用shift, & 以及 加一去完成
 */

// 把原来的n跟1 and 看最sinificant bit是不是一，是的话结果就加一，但是同时结果要想左移动。
public class ReverseBits {

    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}
