package BucketSort;

/**
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 */

// 这一题不需要用到sort的思想，但就是bucket sort 或者脚bucket count!! 这题有follow up问题！
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] chars = new int[26];
        for(Character ch: s.toCharArray()){
            chars[ch - 'a']++;
        }

        for(Character ch: t.toCharArray()){
            chars[ch - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(chars[i] != 0){
                return false;
            }
        }
        return true;
    }
}
