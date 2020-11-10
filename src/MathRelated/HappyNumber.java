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
 * 思路： 用一个hashset去去除circle的情况, 同时用两个while loop 第一个是防止circle 第二个是读取整个新的数字。
 */

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int newNumber = n;
        int squareNumber = 0;

        while (!set.contains(newNumber)) {
            set.add(newNumber);

            while (newNumber != 0) {
                int singleNumber = newNumber % 10;
                squareNumber += singleNumber * singleNumber;
                newNumber = newNumber / 10;
            }

            if (squareNumber == 1) {
                return true;
            }
            newNumber = squareNumber;
            squareNumber = 0;
        }
        return false;
    }
}
