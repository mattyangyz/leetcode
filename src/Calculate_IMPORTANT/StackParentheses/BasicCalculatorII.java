package Calculate_IMPORTANT.StackParentheses;

import java.util.Stack;

/**
 *
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * 思路: 读取数字的时候，读i+1的。同时理解 stck.push(num）或stack.push(-num)的时候， 这个符号是根据上一个sign的值的，因为
 * 符号跟在num之前的。
 *
 */

// 这里的calculate要分开两种情况，一种是当前是digit，第二种是现在是符号，分成这两大类。
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII.calculdate("3-2*2");
    }

    public static int calculdate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
