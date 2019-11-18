package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * Example 2:
 * <p>
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 * <p>
 * <p>
 * 思路： sliding window里面算比较简单的一题
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                }
                left++;
            }
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }

    public int lengthOfLongestSubstringKDistinctWithArray(String s, int k) {

        int[] count = new int[256];
        int left = 0;
        int longest = 0;
        int uniqueChars = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c] == 0) {
                uniqueChars++;
            }
            count[c]++;

            while (uniqueChars > k) {
                char leftChar = s.charAt(left);
                count[leftChar]--;
                if (count[leftChar] == 0) {
                    uniqueChars--;
                }
                left++;
            }
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }


}
