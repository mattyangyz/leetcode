package SlidingWindow.SlidingWindowSubstringSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 思路跟 MinimumWindowSubstring 一模一样
 * <p>
 * 总结： https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 * <p>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * 题意: 给定一个target string，找出所有index 从这个index开始，所有字母在target string里面都出现的， 不能多不能少的。
 * 譬如 cbaebabacd target abc， index 0 符合，但是如果 cb e aebabacd 多了个e，那么index 0就不能算。
 */

// anagram 就是 abc 和 bca 就符合，字母出现的次数一样 只是位置不一样。 这就是anagram
// 思路和代码完全跟 minimumWindowSubstring 一样， 都是不断往右边走 一旦全部char在p里都出现了 就缩小左边的。
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int countFindAllOccurance = map.size();                      // 这里必须是map的size，不能是t的长度 因为p有可能有dup
        int begin = 0;
        int end = 0;

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
                char tempC = s.charAt(begin);
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        countFindAllOccurance++;
                    }

                }
                if (end - begin == p.length()) {                      // 这里是唯一跟MinimumWindowSubstring不一样的地方
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }
}
