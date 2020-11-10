package DP_Hard.RunningWordsCalculate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 非常难。
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * Output:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * Example 2:
 * <p>
 * Input:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * Output:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * Explanation: Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output:
 * []
 * <p>
 * <p>
 * <p>
 * 思路: c a t s a n d d o g
 *      0 1 2 3 4 5 6 7 8 9
 * start : 0 map : empty
 * end : 3 进行 dfs                  ->递归返回     res: "cat sand dog"    map : 7 -> dog 3 -> sand dog 0 -> "cat sand dog"
 * start : 3 map : empty
 * end : 7 进行 dfs              ->递归返回     res: "sand dog"       map : 7 -> dog, 3 -> sand dog
 * start : 7 map : empty
 * end : 10                  ->递归返回     res: "dog"           map : 7 -> dog
 * <p>
 * <p>
 * <p>
 * 上面 start = 0, end = 3完成的时候， end继续进行到4然后继续行走
 */

public class WordBreakII {

    HashMap<Integer, List<String>> map = new HashMap<>();  // Integer -> index

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    public List<String> dfs(String s, List<String> wordDic, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDic.contains(s.substring(start, end))) { // 一开始这里的时候， start=0 end=3的时候会进入这里。然后下一个DFS 从end的位置开始，
                List<String> list = dfs(s, wordDic, end);
                for (String temp : list) {
                    res.add(s.substring(start, end) + (temp.equals("") ? "" : " ") + temp);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}
