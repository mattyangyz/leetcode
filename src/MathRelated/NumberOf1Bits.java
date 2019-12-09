package MathRelated;


/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 * <p>
 * <p>
 * <p>
 * 思路： In Java we need to put attention on the fact that the maximum integer is 2147483647.
 * Integer type in Java is signed and there is no unsigned int.
 * So the input 2147483648 is represented in Java as -2147483648 (in java int type has a cyclic representation,
 * that means Integer.MAX_VALUE+1==Integer.MIN_VALUE).
 */

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int ones = 0;

        while (n != 0) {
            ones += (n & 1);
            n >>>= 1;           // 注意这里， 必须是 >>> shifting unsigned operations.
        }
        return ones;
    }

}
