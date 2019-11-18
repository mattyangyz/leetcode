package TopologicalSort;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
 * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 * Derive the order of letters in this language.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * <p>
 * Output: "wertf"
 * <p>
 * wrt, wrf -> tf
 * wrf, er -> we            -> we rtf
 * er, ett -> rt
 * ett, rftt -> er
 * <p>
 * You may assume all letters are in lowercase.
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * <p>
 * <p>
 * 思路 -> 图 -> 入度为0 -> BFS
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        Map<Character, Set<Character>> map = new HashMap<>();

        int[] degree = new int[26];
        int count = 0;                          // count distinct, 跟CourseSchedule里面的numCourses是一样的

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    count++;
                    degree[c - 'a'] = 1;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);    //"er", "ert" 这种的话是无法比较的，所以取最小值就可以了
            for (int j = 0; j < len; j++) {                   // 这里是构建一个图
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {       // 关键
                        degree[next[j] - 'a']++;
                    }
                    break;                                  // 理解这里为什么是break
                }
            }                                               // 构图结束
        }

        // BFS
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 1) {
                queue.offer((char) ('a' + i));
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            if (map.containsKey(c)) {
                for (char ch : map.get(c)) {
                    if (--degree[ch - 'a'] == 1) {
                        queue.offer(ch);
                    }
                }
            }
        }
        if (res.length() != count) {
            return "";
        }
        return res.toString();
    }
}
