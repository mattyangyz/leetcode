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

// 每个字母只出现在其中一个字串中，思路： https://www.youtube.com/watch?v=nKf6wJ6SCa8
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }

        List<Integer> list = new ArrayList<>();

        int partialEnd = 0;                     // 把这个想象成结果里面的每一段的end
        int partialStart = 0;

        for (int i = 0; i < S.length(); i++) {

            int lastIndex = map.get(S.charAt(i));
            partialEnd = Math.max(partialEnd, lastIndex);

            if (i == partialEnd) {                // 说明当前到 i 位置， 碰见的所有元素都在这个partialEnd的范围之内
                list.add(partialEnd - partialStart + 1);
                partialStart = partialEnd + 1;
                partialEnd = partialEnd + 1;
            }
        }
        return list;
    }
}
