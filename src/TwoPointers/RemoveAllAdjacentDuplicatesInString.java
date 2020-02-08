package TwoPointers;

import java.util.Stack;

/**
 * Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 * <p>
 * We repeatedly make duplicate removals on S until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.
 * The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 * <p>
 * 题意: 把两个相邻重复的元素去掉，直到所有的重复元素都被去掉才停止。
 * <p>
 * 思路: 用一个stack去看当前元素是否跟stack的顶部一样，一样的话 就把顶部抽出来 同时当前元素不会被insert。
 * 或者用two pointers的话会更快。
 */


public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {       // 当前元素不会被insert
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public String removeDuplicatesTwoPointers(String s) {
        int indexToSet = 0;
        int n = s.length();
        char[] res = s.toCharArray();

        for (int j = 0; j < n; j++) {
            res[indexToSet] = res[j];
            if (indexToSet > 0 && res[indexToSet] == res[indexToSet - 1]) {     // 这里必须是indexToSet
                indexToSet -= 2;
            }
        }
        return new String(res, 0, indexToSet);
    }
}
