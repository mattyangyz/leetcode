package Array.TopKBucketSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Share
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * <p>
 * 思路： bucket sort, 先统计每个char有多少的次数，然后将相同次数的合并起来， 最后再由最后到最前去看次数是否null 如果不是就加入。
 */


public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (Character cha : s.toCharArray()) {
            map.put(cha, map.getOrDefault(cha, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];       // 注意这里一定要加一， 不然 eeeee 这种情况就会导致index out of bound.

        for (Character cha : map.keySet()) {
            int freq = map.get(cha);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(cha);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Character ch : bucket[i]) {                    // TODO: 注意这里要nesting的loop
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}
