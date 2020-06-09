package MathRelated.BitMultiplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */

// 思路： 0000 1111 表示 abcd， 1111 0000 表示efgh。 用 & 判断重复的char，用 | 加上之前的值。
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static int maxLength(List<String> A) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        int res = 0;

        for (String s : A) {
            int currWord = 0, duplicate = 0;
            for (char c : s.toCharArray()) {                     // 自己单词内先比较 有没有重复的， 有的话就不用继续下去了

                duplicate = currWord & (1 << (c - 'a'));         // 这里是跟之前一个 & 看有没有重复的bit
                if (duplicate > 0) {
                    break;
                }
                currWord |= 1 << (c - 'a');                      // 这是 01 然后往👈移动c-a位数， |= 是加上之前的a值
            }

            if (duplicate == 0) {
                for (int i = dp.size() - 1; i >= 0; --i) {
                    if ((dp.get(i) & currWord) > 0) continue;    // 有重复的话
                    dp.add(currWord | dp.get(i));                // currWord | dp.get(i) 就是把现在的单词加上去
                    res = Math.max(res, Integer.bitCount(dp.get(i) | currWord));
                }
            }
        }
        return res;
    }

    private int countBits(int number) {     // count how many bits are there in a number
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }
}
