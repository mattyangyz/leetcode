package Array.TopKBucketSort;

import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 * <p>
 * <p>
 * 思路： 把word放到一个frequency map里面，然后建立一个bucket， 同时必须有一个max var记录遇到的最大值。
 * 把所有freq相同的word放到一个bucket下面。 这个bucket必须是 array of List -> List<String>[]
 * <p>
 * <p>
 * 时间复杂度： O(NlogN) time，
 */


public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String>[] bucket = new ArrayList[words.length];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        List<String> res = new ArrayList<>();

        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                for (int j = 0; j < (bucket[i]).size() && res.size() < k; j++) {
                    res.add(bucket[i].get(j));
                }
            }
        }
        return res;

    }
}
