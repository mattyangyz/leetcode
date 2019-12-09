package MathRelated;

import java.util.HashMap;

/**
 * 非常难 并木有算法而言 暴力解法
 * <p>
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * <p>
 * <p>
 * <p>
 * 思路: 小数部分 如果是0.234 3434这样的话， 如果除数到0.234 再出现3的话 那必定是3434这样
 * <p>
 * The important thing is to consider all edge cases while thinking this problem through,
 * including: negative integer, possible overflow, etc.
 * <p>
 * Use HashMap to store a remainder and its associated index while doing the division
 * so that whenever a same remainder comes up, we know there is a repeating fractional part.
 * <p>
 * Please comment if you see something wrong or can be improved. Cheers!
 */

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        res.append((numerator > 0) ^ (denominator > 0) ? "-" : "");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        res.append(num / den);                          // 整数部分
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // 有小数出现， 如果 2/3 就是 2 % 3 = 2
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();       // length用来插入（ 时用作offset 比如2/3 未进入while时候是0. 所以map是 key 2:  value 2
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;                              // 2 / 3 的时候余数 2乘以10 再计算得到的数
            res.append(num / den);                  // res原本是0. 这一步之后就变成了0.6
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");         //这里是insert到specific index
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}
