package Stack;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * <p>
 * <p>
 * 思路: 从高位开始删， 一个一个相邻的去比较。Stack 存的是最终的结果， 每当往右走的时候，peek当前的出来比较。
 */
public class RemoveKDigits {

    public String removeKDigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {                 // edge case 防止 num = 1111, k = 2这种情况。1111都在stack里面，然后k没有动过
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int res = 0;
        while (res < sb.length() && sb.charAt(res) == '0') { // edge case 防止 num=10200 k=1 最后结果是0200这种情况。
            res++;
        }
        return res == sb.length() ? "0" : sb.substring(res); // edge case res == sb.length()  防止00这种情况， 返回一个0就行
    }
}
