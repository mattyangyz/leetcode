package Stack;

import java.util.Stack;

/**
 * 思路: 不算难的stack题目。
 */

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int curr : asteroids) {

            //  empty的时候 或 符号相同的时候 或 两边走的手
            if (stack.isEmpty() || curr * stack.peek() > 0 || (stack.peek() < 0 && curr > 0)) {
                stack.push(curr);
            } else {
                boolean flag = true;

                // 用 while 来控制 curr 连锁反应的情况，就像这种 [10, 2, -5]
                // -5 需要跟 2 撞击 也需要跟 10 撞击。
                while (!stack.isEmpty() && stack.peek() * curr < 0) {
                    if (Math.abs(stack.peek()) == Math.abs(curr)) {
                        stack.pop();
                        flag = false;
                        break;
                    } else if (Math.abs(stack.peek()) < Math.abs(curr)) {  // stack peek < curr
                        stack.pop();
                    } else {               // stack top > curr
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    stack.push(curr);
                }
            }
        }

        int size = stack.size();
        int[] res = new int[size];
        int index = size - 1;
        while (stack.size() > 0) {
            res[index--] = stack.pop();
        }
        return res;
    }
}
