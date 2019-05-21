package String;

import java.util.HashSet;
import java.util.Set;

/**
        Use two pointers, one slow one fast, move the fast one. if having dup, then remove char starts from i.
        Given "abcabcbb", the answer is "abc", which the length is 3.
        Given "bbbbb", the answer is "b", with the length of 1.
        Given "pwwkew", the answer is "wke", with the length of 3
**/
public class LongestSubstringWithoutRepeatingCharacters {

    public int longestSubstringWithoutRepeatingCharacters(String s) {

        int ans = 0;
        int slow = 0;
        int fast = 0;

        Set<Character> set = new HashSet<>();
        while (slow < s.length() && fast < s.length()) {
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
