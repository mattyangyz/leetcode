package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * <p>
 * 思路: 用map去记录最后的位置，然后遍历每个char，更新碰见字母的最后出现index。
 */

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = S.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        int start = 0;
        int end = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            int lastIndex = map.get(chars[i]);

            end = Math.max(end, lastIndex);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
