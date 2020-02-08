package BinarySearch.FindFirstElementThatGreaterThanTargetFromLeftInSortedArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a string t, check if s is subsequence of t.
 * <p>
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * <p>
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * <p>
 * Example 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * Return true.
 * <p>
 * Example 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * Return false.
 * <p>
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 */


public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


    /**
     * 建立这样一个map ->  a -> 0
     * b -> 1
     * c -> 3
     * d -> 2,5
     * e -> 4
     * <p>
     * For instance, if S = "abcd" and T = "abdced".
     * The index list mapping looks like,
     * <p>
     * a -> 0
     * b -> 1
     * c -> 3
     * d -> 2,5
     * e -> 4
     * After you pick a, and b, c will be picked, and index is 3.
     * Now if you have to pick d, you can't pick index 2 because c was picked at 3,
     * so you have to binary search for index which comes after 3. So it returns 5.
     */
    public boolean isSubsequenceWithBinarySearch(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new ArrayList<>());
            }
            map.get(t.charAt(i)).add(i);
        }

        int preIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int currIndex = search(map.get(ch), preIndex);
            if (currIndex < 0) {
                return false;
            }
            preIndex = currIndex;
        }
        return true;
    }

    public int search(List<Integer> list, int preIndex) {
        if (list == null) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= preIndex) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return list.get(left) > preIndex ? list.get(left) : -1;
    }
}
