package Array.SlidingWindow;

import java.util.HashMap;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

/**
 *
 *
 * 大致思路， 不断向右变扩大， 知道找到satisfy的window 然后开始从左边shirking， shirking的同时坚持shirk完后的window时候包含t.
 * 重要思路: 满足条件 左边shirk， 不满足条件 向右边扩大
 *
 *
 * 1. 把所有s的char放到hashmap里， 然后t也放进去 算有多少次的出现
 *
 * 2. go over 每个char 在s里面
 *
 */


public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int startWindow = 0;
        int endWindow = 0;

        int startOfMinString = 0; // track the start pos of min string
        int minLen = Integer.MAX_VALUE; // the lenght of min string

        int counter = t.length(); // counter represents the number of chars of t to be found in s

        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }

        while (endWindow < s.length()) {
            char cur = s.charAt(endWindow);                 // 遍历s， 对于每个字母 都在hashmap里面减一

            if (map.get(cur) > 0) {                         // 当前的char， 包含在s里面 而且只考虑第一次见的情况 ADZABC ABC 第二次见到的话就不考虑了
                counter--;
            }
            map.put(cur, map.get(cur) - 1);

            while (counter == 0) {                       // current的window里面s包含t
                if (minLen > endWindow - startWindow + 1) {
                    startOfMinString = startWindow;
                    minLen = endWindow - startWindow + 1;       // update the length of min string
                }

                char c2 = s.charAt(startWindow);
                map.put(c2, map.get(c2) + 1);
                if (map.get(c2) > 0) {
                    counter++;
                }
                startWindow++;
            }
            endWindow++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startOfMinString, startOfMinString + minLen);
    }

    public static String minWindow2(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        int startWindow = 0;
        int endWindow = 0;

        int startOfMinString = 0;
        int minLength = Integer.MAX_VALUE;

        int count = t.length();

        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }

        while (endWindow < s.length()) {                // 先找到一个window符合条件的，然后在shrink 这是重点

            char c = s.charAt(endWindow);
            if (map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);

            while (count == 0) {                        // 找到了符合条件的， 现在开始shrink
                if (minLength > endWindow - startWindow + 1) {
                    startOfMinString = startWindow;
                    minLength = endWindow - startWindow + 1;
                }

                char c2 = s.charAt(startWindow);
                map.put(c2, map.get(c) + 1);
                if (map.get(c2) > 0) {                  // 说明t 已经不再s里面了
                    count++;
                }
                startWindow++;
            }
            endWindow++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startOfMinString, startOfMinString + minLength);
    }

}
