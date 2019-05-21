package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShorestWordDistanceII {

    HashMap<String, List<Integer>> map = new HashMap<>();

    public ShorestWordDistanceII(String[] words) {

        for (int i = 0; i < words.length; i++) {
            List<Integer> count = map.get(words[i]);
            if (count == null) {
                count = new ArrayList<>();
            }
            count.add(i);
            map.put(words[i], count);
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
            if(idx1.get(i) > idx2.get(j)){
                j++;
            }
            else{
                i++;
            }
        }
        return distance;
    }
}
