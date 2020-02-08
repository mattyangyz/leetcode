package Backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Linkedin
 * <p>
 * Numbers can be regarded as product of its factors. For example,
 * <p>
 * 8 = 2 x 2 x 2;
 * = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 * <p>
 * Note:
 * <p>
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 * Example 1:
 * <p>
 * Input: 1
 * Output: []
 * Example 2:
 * <p>
 * Input: 37
 * Output:[]
 * Example 3:
 * <p>
 * Input: 12
 * Output:
 * [
 * [2, 6],
 * [2, 2, 3],
 * [3, 4]
 * ]
 * Example 4:
 * <p>
 * Input: 32
 * Output:
 * [
 * [2, 16],
 * [2, 2, 8],
 * [2, 2, 2, 4],
 * [2, 2, 2, 2, 2],
 * [2, 4, 4],
 * [4, 8]
 * ]
 *
 * 思路: 用backtracking去做，但是要注意必须注意以下两点 1. factor的定义是从2开始，小于n 2. 必须是 i <= number。
 * 其实这个可以有优化的。
 *
 */

public class FactorCombinations {

    public static List<List<Integer>> getFactor(int number) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(number, 2, result, list);                // key is start from 2 instead of 0 or 1
        return result;
    }

    public static void helper(int number, int start, List<List<Integer>> result, List<Integer> curr) {
        if (number == 1) {
            if (curr.size() > 1) {                  // 这里必须是 > 1，不能是大于0， 因为factor的定义是 > 1 而且 < n
                result.add(new ArrayList<>(curr));
            }
            return;
        } else {
            for (int i = start; i <= number; i++) {  // key point is here it MUST BE i <= number
                if (number % i == 0) {
                    curr.add(i);
                    helper((number / i), i, result, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
