package SlidingWindow.SlidingWindowSubstringSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 难
 * <p>
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "eceba"
 * Output: 3
 * Explanation: t is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: t is "aabbb" which its length is 5.
 * <p>
 * 1. 这里的counter是init成0， 跟minimumSubstringWindow和FindAllAnagramsInString不一样
 * <p>
 * 2. 什么时候去increment count是关键
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int counter = 0;
        int ans = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) {
                counter++;          // find a new character
            }
            end++;
            while (counter > 2) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    counter--;
                }
                start++;
            }
            ans = Math.max(ans, end - start);                       // 这个必须得在第二个while loop的外面， 每次都更新。
        }
        return ans;
    }
}
