package MathRelated;

import java.util.HashSet;
import java.util.Set;


/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * 思路： 用一个hashset去去除circle的情况
 */

public class HappyNumber {

    public boolean isHappy(int number) {

        Set<Integer> set = new HashSet<>();
        int squareSum;
        int remain;

        while (set.add(number)) {
            squareSum = 0;
            while (number > 0) {
                remain = number % 10;
                squareSum += remain * remain;
                number = number / 10;
            }
            if (squareSum == 1) {
                return true;
            }
            number = squareSum;
        }
        return false;
    }
}
