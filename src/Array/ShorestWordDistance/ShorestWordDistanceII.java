package Array.ShorestWordDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * Your method will be called repeatedly many times with different parameters.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 */

public class ShorestWordDistanceII {

    HashMap<String, List<Integer>> map;

    public ShorestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shorestWordDistance(String word1, String word2) {
        List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < idx1.size() && j < idx2.size()) {
            distance = Math.min(distance, Math.abs(idx1.get(i) - idx2.get(j)));
            if (idx1.get(i) > idx2.get(j)) {          // 关键在于这里。
                j++;
            }
            else{
                i++;
            }
        }
        return distance;
    }
}
