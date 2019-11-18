package StringRelated.Pattern;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomophicString {

    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char currCharS = s.charAt(i);
            char currCharT = t.charAt(i);

            if (!map.containsKey(currCharS)) {
                map.put(currCharS, currCharT);
            }
            if (!map2.containsKey(currCharT)) {
                map.put(currCharT, currCharS);
            }

            if (map.get(currCharS) != currCharT || map2.get(currCharT) != currCharS) {
                return false;
            }
        }
        return true;
    }
}
