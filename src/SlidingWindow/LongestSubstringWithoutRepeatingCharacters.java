package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/** Linkedin
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * 思路: 两个pointer。当快的遇到在字典里面包含dup的时候， 从set里面remove slow的。知道之前那个遇到的dup不再出现在字典里
 *
**/
public class LongestSubstringWithoutRepeatingCharacters {

    public int longestSubstringWithoutRepeatingCharacters(String s) {

        int ans = 0;
        int slow = 0;
        int fast = 0;

        Set<Character> set = new HashSet<>();
        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow++));
            }
            else{
                set.add(s.charAt(fast++));
                ans = Math.max(ans, fast - slow);
            }
        }
        return ans;
    }
}
