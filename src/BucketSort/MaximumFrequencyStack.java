package BucketSort;

import java.util.*;


/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 */

// 总体的思路就是用map存key与freq的关系，然后bucket是list of stack，同一个stack里面存的是同样freq的所有key，这是根据题目一下要求
// If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
// 当某个已经存在的key再进来需要增加的时候，如果超过了最大的max freq，需要开拓一个新的bucket出来，但同时旧的stack不需要remove 这个要掌握。
public class MaximumFrequencyStack {

    List<Stack<Integer>> bucket;
    Map<Integer, Integer> map;

    public MaximumFrequencyStack() {
        bucket = new ArrayList<>();
        map = new HashMap<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        int freq = map.get(x);
        if (freq - 1 >= bucket.size()) {            // 这个freq是最大的
            bucket.add(new Stack<>());
        }
        bucket.get(freq - 1).add(x);
    }

    public int pop() {
        int fre = bucket.size();
        int x = bucket.get(fre - 1).pop();
        if (bucket.get(fre - 1).isEmpty()) {
            bucket.remove(bucket.size() - 1);
        }

        map.put(x, map.get(x) - 1);         // 新的freq要被update， 因为push的时候要用到
        if (map.get(x) == 0) {
            map.remove(x);
        }
        return x;
    }
}
