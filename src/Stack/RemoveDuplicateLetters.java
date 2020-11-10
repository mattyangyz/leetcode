package Stack;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb" 而不是adbc是因为 ac在ad 的lexi前面
 * <p>
 * 思路: 题意解释看这里。https://www.youtube.com/watch?v=SrlvMmfG8sA
 * <p>
 * 用count array看后面还有没有这个元素(peek)，用used看stack中是否已经包含了这个元素(peek)。
 * 如果当前的字母lex小于stack上的，如果这个stack上的字母后面还会出现 则pop出来，否则就留着。
 * <p>
 * 2020-JUN-09
 */

// count用来记录后面还有多少的这个字母，used用来记录这个字母之前有没有已经用过。
// 然后一个一个字母地加，如果当前的字母小于stack顶端的，而且stack顶端那么字母后面还有的话，就把stack顶端
// 的字母pop出来，等到后面再加，记得pop的时候要把used设置成false。
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(RemoveDuplicateLetters.removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        boolean[] used = new boolean[26];

        for (char c : s.toCharArray()) {           // 统计有多少
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            int index = c - 'a';
            count[index]--;
            if (used[index]) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                used[stack.pop() - 'a'] = false;

            }
            used[index] = true;
            stack.push(c);
        }

        // 最后的处理
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
