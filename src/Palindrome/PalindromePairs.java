package Palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 * <p>
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * <p>
 * 思路:
 *
 * Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
 *
 * Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
 *
 * Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:end] , then s2+s1 is palindrome.
 *
 * Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
 *
 * To make the search faster, build a HashMap to store the String-idx pairs.
 */

// 不可能出现aaaa然后aaaa这种情况。 不然的话1和3就会出现重复的问题。
// 遍历整个words array，然后分四种情况去考虑。
public class PalindromePairs {


    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        // build the map save the key-value pairs: String - idx
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        //1 "" can combine with any palindrom string
        if (map.containsKey("")) {
            int blankIndex = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrom(words[i])) {
                    if (i == blankIndex) continue;
                    res.add(Arrays.asList(blankIndex, i));
                    res.add(Arrays.asList(i, blankIndex));
                }
            }
        }

        //2 find all string and reverse string pairs
        for (int i = 0; i < words.length; i++) {
            String cur_reverse = reverseStr(words[i]);
            if (map.containsKey(cur_reverse)) {
                int found = map.get(cur_reverse);
                if (found == i) continue;
                res.add(Arrays.asList(i, found)); // 这里只需要加一次就够了，剩下的会在下一次的时候加进来。
            }
        }

        //3 4
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {

                //处理 aalc 和 cl 这种情况，先判断cut的前面时候为pal 然后判断cut后面的string，也就是aalc的时候cut在aa，找后面的lc情况。
                if (isPalindrom(cur.substring(0, cut))) {               // aalc 和 cl这种情况， 这样cl一定得放前面 found放前面
                    String cut_reverse = reverseStr(cur.substring(cut));
                    if (map.containsKey(cut_reverse)) {
                        int found = map.get(cut_reverse);
                        if (found == i) {
                            continue;
                        }
                        res.add(Arrays.asList(found, i));
                    }
                }

                // 处理acbcb和ca这种情况的，先判断cut的后面时候为pal 然后判断cut的前面的string。
                // 这里一定不能用 else if，为了防止 aa和a这种情况被skip了，因为a可以放在aa的前面和后面都可以的。
                if (isPalindrom(cur.substring(cut))) {                  // aaaalc 和 aaaa这种情况，这样aaaa一定得放后面
                    String cut_reverse = reverseStr(cur.substring(0, cut));
                    if (map.containsKey(cut_reverse)) {
                        int found = map.get(cut_reverse);
                        if (found == i) {
                            continue;
                        }
                        res.add(Arrays.asList(i, found));
                    }
                }
            }
        }
        return res;
    }

    public String reverseStr(String string) {
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    public boolean isPalindrom(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
