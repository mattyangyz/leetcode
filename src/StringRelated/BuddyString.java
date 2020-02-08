package StringRelated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 */


public class BuddyString {

    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) { // If A == B, we need swap two same characters. Check is duplicated char in A.
            Set<Character> set = new HashSet<>();
            for (char ch : a.toCharArray()) {
                if (set.contains(ch)) {
                    return true;
                }
                set.add(ch);
            }
            return false;
        }

        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) { // In other cases, we find index for A[i] != B[i]. There should be only 2 diffs and it's our one swap.
            if (a.charAt(i) != b.charAt(i)) {
                dif.add(i);
            }
        }
        return dif.size() == 2 && a.charAt(dif.get(0)) == b.charAt(dif.get(1)) && a.charAt(dif.get(1)) == b.charAt(dif.get(0));
    }
}
