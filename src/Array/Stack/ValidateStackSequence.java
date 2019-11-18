package Array.Stack;

import java.util.ArrayDeque;
import java.util.Deque;


// not yet
public class ValidateStackSequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stk = new ArrayDeque<>();
        int i = 0;
        for (int p : pushed) {
            stk.push(p);
            while (!stk.isEmpty() && stk.peek() == popped[i]) {
                stk.pop();
                ++i;
            }
        }
        return stk.isEmpty();
    }
}
