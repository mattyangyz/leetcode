package Stack;

import java.util.Stack;

/**
 *
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 *
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 *
 * 思路: 不算难的stack题目。
 */

// 思路: 大体两种思路 第一 如果当前的符号跟stack顶的符号相同的话，就push到stack，同时
// 如果stack顶是往左边，curr往右边的话 也push进去。第二 如果上面情况都不是的话，就可以形成碰撞
// 要用while loop处理，如果stack顶和curr一样的话，就break， 如果stack顶大于curr的话，就break，
// 只有在curr大于stack顶部的时候才不break，而且这样的话得把curr push到stack里面去
public class AsteroidCollision {

    public int[] asteroidCollision(int[] array) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < array.length) {

            // 这是空，还有往两边走 还有往同一方向的情况
            if (stack.isEmpty() || (stack.peek() < 0 && array[i] > 0) || stack.peek() * array[i] > 0) {
                stack.push(array[i]);
                i++;
            } else {
                if (Math.abs(array[i]) > Math.abs(stack.peek())) {
                    stack.pop();
                } else if (Math.abs(array[i]) < Math.abs(stack.peek())) {
                    i++;
                    continue;
                } else {
                    stack.pop();
                    i++;
                }
            }
        }

        int[] res = new int[stack.size()];
        int count = stack.size() - 1;
        while (count >= 0) {
            res[count--] = stack.pop();
        }
        return res;
    }
}
