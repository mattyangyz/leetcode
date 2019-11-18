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
 */


public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int slow = 0;
        int fast = 0;
        int countForAllOccurance = map.size();

        while (fast < s.length()) {

            char fastChar = s.charAt(fast);
            if (map.containsKey(fastChar)) {
                map.put(fastChar, map.get(fastChar) - 1);
                if (map.get(fastChar) == 0) {
                    countForAllOccurance--;
                }
            }
            fast++;

            while (countForAllOccurance == 0) {

                if (fast - slow == p.length()) {
                    ans.add(slow);
                }
                char slowChar = s.charAt(slow);
                if (map.containsKey(slowChar)) {
                    map.put(slowChar, map.get(slowChar) + 1);
                    if (map.get(slowChar) > 0) {
                        countForAllOccurance++;
                    }
                }
                slow++;
            }
        }
        return ans;
    }
}
