package Backtracking;


/**
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 * <p>
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 * Note:
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 * <p>
 * 思路，用backtracking去做。因为有除法，所以用double。https://www.youtube.com/watch?v=Vbcl5jmm05E
 */


public class TwentyFourGame {

    public boolean judgePoint24(int[] num) {
        double[] input = new double[]{num[0], num[1], num[2], num[3]};

        return helper(input);
    }

    private boolean helper(double[] input) {

        if (input.length == 1) {
            return Math.abs(input[0] - 24) < 0.001;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                double[] resultOfRemainingNumbers = new double[input.length - 1];

                for (int k = 0, index = 0; k < input.length; k++) {
                    if (k != i && k != j) {     // 先把不是 i j 的加入到resultOfRemainingNumbers
                        resultOfRemainingNumbers[index] = input[k];
                        index++;
                    }
                }

                // 把 i j 组成的六种结果 分别放入到array
                for (double partialResult : compute(input[i], input[j])) {
                    resultOfRemainingNumbers[resultOfRemainingNumbers.length - 1] = partialResult;
                    if (helper(resultOfRemainingNumbers)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private double[] compute(double x, double y) {
        return new double[]{x + y, x - y, x * y, x / y, y - x, y / x};
    }
}
