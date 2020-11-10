package Stack.Parentheses;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "lee(t(c)o)de)"
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 * <p>
 * Input: s = "a)b(c)d"
 * Output: "ab(c)d"
 * Example 3:
 * <p>
 * Input: s = "))(("
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 * <p>
 * Input: s = "(a(b(c)d)"
 * Output: "a(b(c)d)"
 * <p>
 * 思路: 同时用stack去记录invalid的index， 这个要仔细想想问什么这么做。
 * 为什么是存index呢，因为方便最后对于有多余的(，把stack里面的所有(都替换成*。这个是关键。
 * 而且要理解stack里面只存 （ 的position，对于 ） 不存。
 * 碰到不匹配的（和）的时候，用*去标记，最后用replaceAll去把所有invalid的去掉。
 * 为什么要用*呢，因为不能马上去掉，这样就会造成shift的出现 for loop的位置会不对。
 */


public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                stack.add(i);
            }
            if (sb.charAt(i) == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '0');
                }
            }
        }
        while (!stack.empty()) {
            sb.setCharAt(stack.pop(), '0');
        }
        return sb.toString().replaceAll("0", "");
    }
}
