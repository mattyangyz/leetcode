package Calculate_IMPORTANT.StackParentheses;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 * <p>
 * 1 + 4 - (1 - 3)
 */

// 分开四种情况来考虑， number， 加减法，以及括号。遇到括号的话就需要用到stack了，
// 遇到开括号就把res跟sign push到stack里面。要用i + 1去读取整个数字 以及判断下一个digit是否为数字。
// 要理解哪里开始计算res，以及那里的sign是怎么来的。这个是关键。

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator.calculate("(12+(4+5+2)-3)+(6+8)");
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {      // 读取整个数字
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;                                                      // 这个sign其实是上一个loop的时候决定的
            } else if (s.charAt(i) == '+') {                                            // 分四种情况讨论
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                int tempSign = stack.pop();
                int tempRes = stack.pop();
                res = tempRes + tempSign * res; // res是括号里面的结果，tempRes是(之前的结果
            }
        }
        return res;
    }
}
