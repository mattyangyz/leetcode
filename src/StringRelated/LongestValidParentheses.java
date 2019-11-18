package StringRelated;

import java.util.LinkedList;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1); // this is for the case "()()"

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){ // stack.size() > 1 is for ")"
                stack.pop();
                result = Math.max(result, i - stack.peek());
            }
            else{
                stack.push(i);
            }
        }
        return result;
    }
}