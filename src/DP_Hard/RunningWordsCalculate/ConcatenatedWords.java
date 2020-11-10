package DP_Hard.RunningWordsCalculate;

import java.util.*;

/**
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * Example:
 * Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * <p>
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * <p>
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Note:
 * The number of elements of the given array will not exceed 10,000
 * The length sum of elements in the given array will not exceed 600,000.
 * All the input string will only include lower case letters.
 * The returned elements order does not matter.
 * <p>
 * 思路: 先排序，先处理掉短的单词 因为长的单词是由短的构成的。 先把短的放到set里面，后面处理长单词的时候就能
 * 让长的单词可以从短的单词里面找到结果。如果不排序的话，像遇到 "cat","cats","catsdogcats","dog"， 这样的话
 * 第三个catsdogcats就没法判断dog是否在dict里面，所以应该先处理 cat dog cats catsdogcats 这样的顺序。
 * <p>
 * O(m * n * n）
 */

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int i = 0; i < words.length; i++) {
            if (helper(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    // 除了第二个input parameter不一样，其他都一样, 这里必须用set 不然会超时呢。
    public boolean helper(String s, Set<String> wordDict) {
        if (wordDict.isEmpty()) { // 唯一与word break 不同的地方就是这里。
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
