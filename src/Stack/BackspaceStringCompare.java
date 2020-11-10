package Stack;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * <p>
 * 思路: 两种做法，一种是stack，一种是two pointer。
 */

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        return compute(S).equals(compute(T));
    }

    private String compute(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack.toString();
    }

//    public boolean backspaceCompareOOne(String s, String t){
//        if( s == null || t == null){
//            return s == t;
//        }
//        int m = s.length();
//        int n = t.length();
//        int i = m - 1;
//        int j = n - 1;
//        int count1 = 0;
//        int count2 = 0;
//
//        while( i >= 0 || j >=0){
//
//        }
//    }
}
