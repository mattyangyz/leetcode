package SlidingWindow.SlidingWindowSubstringSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SlidingWindowTemplate {

    public List<Integer> slidingWindowTempldate(String s, String t) {

        List<Integer> result = new LinkedList<>();
        if (t.length() > s.length()) {
            return result;
        }

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //maintain a counter to check whether match the target string.
        int counter = map.size(); //must be the map size, NOT the string size because the char may be duplicate.

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0;
        int end = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        while (end < s.length()) {

            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            end++;

            //increase begin pointer to make it invalid/valid again
            while (counter == 0) {
                char tempC = s.charAt(begin); //***be careful here: choose the char at begin pointer, NOT the end pointer
                if (map.containsKey(tempC)) {
                    map.put(tempC, map.get(tempC) + 1);
                    if (map.get(tempC) > 0) {
                        counter++;
                    }
                }
            }
            begin++;
        }
        return result;
    }
}
