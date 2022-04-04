package Calculate_IMPORTANT.StackParentheses;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * <p>
 * <p>
 * 思路： https://www.youtube.com/watch?v=Qoz3ujccNQY
 * <p>
 * 用两个stack去记录 一个是记录count的，另一个记录prevStringStack。 prevString是用来记录遇到[之前的string的。
 * 要把这个prevString push 到stringStack里面，因为后面遇到]的时候 需要pop出来 然后append到之前的prevString里面。
 * <p>
 * 例子: 3[a2[4[c]]] 把cccc 重复两次 变成 cccccccc后 需要pop a出来然后append到a后面。 这个a就依赖于之前遇到[的时候push进去。
 * 遇到数字的话，把它整个读出来 然后push到countStack里面，遇到 [ 的话 得把之前的prevString放到stack里面 因为有可能遇到多个 [[ 的情况
 *
 */

public class DecodeString {

    public static String deCodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int index = 0;

        String prevString = "";

        while (index < s.length()) {

            if (Character.isDigit(s.charAt(index))) {       //读取整个数字
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);

            } else if (s.charAt(index) == '[') {
                stringStack.push(prevString);               // 后面遇到 ] 的时候要把这个给pop出来的， 所以要push进来先
                prevString = "";
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(stringStack.pop());
                int repeatTime = countStack.pop();
                for (int i = 0; i < repeatTime; i++) {
                    temp.append(prevString);
                }
                prevString = temp.toString();
                index++;
            } else {
                prevString += s.charAt(index++);
            }
        }
        return prevString;
    }
}
