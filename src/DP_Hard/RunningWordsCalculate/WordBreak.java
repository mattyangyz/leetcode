package DP_Hard.RunningWordsCalculate;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 * <p>
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note:
 * <p>
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * <p>
 * <p>
 * 思路：
 * <p>
 * 那么想想如果不用dp做，会是怎么样。
 * <p>
 * 看子字符串是否在字典中，由于给定的字典是数组（之前还是 HashSet 呢），那么我们肯定不希望每次查找都需要遍历一遍数组，费劲！
 * 还是把字典中的所有单词都存入 HashSet 中吧，这样我们就有了常数时间级的查找速度，perfect！
 * 好，我们得开始给字符串分段了，怎么分，只能一个一个分了，先看第一个字母是否在字典中，如果不在的话，好办，说明这种分法肯定是错的。
 * 问题是在的话，后面的那部分怎么处理，难道还用 for 循环？咱也不知道还要分多少段，怎么用 for 循环。
 * 对于这种不知道怎么处理的情况，一个万能的做法是丢给递归函数，让其去递归求解。
 * 这里我们 suppose 递归函数会返回我们一个正确的值，如果返回的是 true 的话，
 * 表明我们现在分成的两段都在字典中，我们直接返回 true 即可，因为只要找出一种情况就行了。
 * 这种调用递归函数的方法就是 brute force 的解法，我们遍历了所有的情况。
 * 优点是写法简洁，思路清晰，缺点是存在大量的重复计算，被 OJ 啪啪打脸
 * <p>
 * <p>
 *
 * todo: 下面这个已经过期了
 * 正确解法： 这里我们就用一个一维的 dp 数组，其中 dp[i] 表示范围 [0, i) 内的子串是否可以拆分，
 * 注意这里 dp 数组的长度比s串的长度大1，是因为我们要 handle 空串的情况，我们初始化 dp[0] 为 true，
 * 然后开始遍历。注意这里我们需要两个 for 循环来遍历，因为此时已经没有递归函数了，所以我们必须要遍历所有的子串，
 * 我们用j把 [0, i) 范围内的子串分为了两部分，[0, j) 和 [j, i)，其中范围 [0, j) 就是 dp[j]，范围 [j, i) 就是 s.substr(j, i)，
 * 其中 dp[j] 是之前的状态，我们已经算出来了，可以直接取，只需要在字典中查找 s.substr(j, i-j) 是否存在了，
 * 如果二者均为 true，将 dp[i] 赋为 true，并且 break 掉，此时就不需要再用j去分 [0, i) 范围了，因为 [0, i) 范围已经可以拆分了。
 * 最终我们返回 dp 数组的最后一个值，就是整个数组是否可以拆分的布尔值了
 * <p>
 * <p>
 * 思路：  l e e t c o d e
 * dp[] T F F F T F F F T      <- 这个是正确的dp数组迭代思路
 *
 * https://www.youtube.com/channel/UCamg61pfZpRnTp5-L4XEM1Q/about
 *
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("leetcode");
        System.out.println(WordBreak.wordBreak("leetcode", list));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] previousResult = new boolean[s.length() + 1];
        previousResult[0] = true;
        Set<String> set = new HashSet<>(wordDict);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {                 // 注意这里一定要等于，因为substring j是不包含的，要+1才能包含
                String subString = s.substring(i, j);

                if (previousResult[i] && set.contains(subString)) {
                    previousResult[j] = true;
                }
            }
        }
        return previousResult[s.length()];
    }

    public static boolean wordBreakOptimize(String s, List<String> wordDict) {
        boolean[] previousResult = new boolean[s.length() + 1];
        previousResult[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!previousResult[i]) {
                continue;
            }

            for (String str : wordDict) {
                int high = i + str.length();
                if (high <= s.length() && s.substring(i, high).equals(str)) {
                    previousResult[high] = true;
                }
            }
        }
        return previousResult[s.length()];
    }
}
