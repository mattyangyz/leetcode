package SlidingWindow.SlidingWindowSubstringSearch;

import java.util.HashMap;
import java.util.Map;

/** Linkedin 难， 跟FindAllAnagramsInAString 一样
 *
 * 总结: https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

/**
 *
 *
 * 大致思路， 不断向右变扩大， 知道找到satisfy的window 然后开始从左边shirking， shirking的同时坚持shirk完后的window时候包含t.
 * 重要思路: 满足条件 左边shirk， 不满足条件 向右边扩大
 *
 *
 * 1. 把所有target的char都放入map里面，看有多少频率
 *
 * 2. 两个pointer，一个startIndex 记得count必须是map的size
 *
 * 3. 两个while loops， 一个是给fast pointer，一个是当全部occurance都找到的时候给慢pointer缩的时候用的
 *
 * 4. 当count == 0的时候代表全部occurance都找到了
 *
 */

// map 存还需要找到这个char多少次。正数表示需要找到的次数，负数表示额外出现了多少次
// countFindAllOccurance 表示 是否所有的unique char都找到了， 它必须等于map的size 而不能是t的length
//
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        if (t.length() > s.length()) return "";

        // 计算还有多少次 我们需要找到这个char, 比如AABC -> a:2 b:1 c:1
        // 我们需要找到a两次，b一次，c一次。如果是负数的话，代表多出来一个。
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int countFindAllOccurance = map.size();                      // 这里必须是map的size，不能是t的长度 因为t有可能有dup
        int begin = 0;
        int end = 0;
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;

        while (end < s.length()) {
            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {                              // 对于char c，所有的occurance都找到了 不多不少
                    countFindAllOccurance--;
                }
            }
            end++;

            while (countFindAllOccurance == 0) {                     // 检查是否包含了所有在target里面的char
                char tempC = s.charAt(startIndex);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        countFindAllOccurance++;
                    }

                }
                if (end - begin < minLength) {                      // 更新minLength
                    minLength = end - begin;
                    startIndex = begin;
                }
                begin++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(startIndex, startIndex + minLength);
    }
}
