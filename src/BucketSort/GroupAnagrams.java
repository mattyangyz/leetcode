package BucketSort;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */

// 用bucket count去得到一个string，两个anagram之间的frequent count一定是一样的, 这个就可以作为key去group
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] key = new int[26];
            for (char ch : str.toCharArray()) {
                key[ch - 'a']++;
            }

            String keyStr = this.arrayToString(key);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }

        return new LinkedList<>(map.values());
    }

    private String arrayToString(int[] key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < key.length; i++) {
            sb.append(key[i]);
        }
        return sb.toString();
    }
}
