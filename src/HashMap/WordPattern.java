package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 * <p>
 * 思路: 要双重check。从a到dog，然后dog是否对应a也要check。
 */

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {

        Map<Character, String> map = new HashMap<>();
        String[] strings = str.split(" ");

        if (strings.length != pattern.toCharArray().length) {
            return false;
        }

        int index = 0;
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strings[index++])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[index])) {
                    return false;
                }
                map.put(c, strings[index++]);
            }
        }
        return true;
    }
}
