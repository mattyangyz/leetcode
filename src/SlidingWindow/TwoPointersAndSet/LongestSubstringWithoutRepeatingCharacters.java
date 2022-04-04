package SlidingWindow.TwoPointersAndSet;

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
 * 思路: 两个pointer。快的往前走，遇到set里面包含的时候，就从slow开始remove 知道remove到set里面不包含fast为止，因为是subsring所以可以
 * 这么干。
 *
**/
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        Set<Character> set = new HashSet<>();

        int slow = 0;
        int fast = 0;

        while(fast != s.length()){
            if(set.contains(s.charAt(fast))){
                set.remove(s.charAt(slow));
                slow++;
            }
            else{
                set.add(s.charAt(fast));
                fast++;
                longestLength = Math.max(longestLength, fast - slow);
            }
        }

        return longestLength;
    }
}
