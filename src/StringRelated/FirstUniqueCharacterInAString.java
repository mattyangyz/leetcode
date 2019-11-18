package StringRelated;


/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * <p>
 * <p>
 * there is a better solution if the input size is big
 */

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String string) {
        int[] chars = new int[26];
        for (int i = 0; i < string.length(); i++) {
            chars[string.charAt(i) - 'a']++;
        }
        for (int i = 0; i < string.length(); i++) {
            if (chars[string.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
