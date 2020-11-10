package Iterator;

import Tree.DFS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 * <p>
 * <p>
 * 思路: In the constructor, we push all the nestedList into the stack from back to front,
 * so when we pop the stack, it returns the very first element. Second, in the hasNext() function,
 * we peek the first element in stack currently, and if it is an Integer,
 * we will return true and pop the element. If it is a list, we will further flatten it.
 * This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.
 */

// 这题要想明白 整道题 都是围绕NestedInteger去做的， 就算是一个single digit也是被NestedInteger给wrap起来的
// 一开始先把所有的element push到stack里面去， 然后在call next的时候开始unwrap，这是思路。
// hasNext 用while是因为 里面的 for 完了之后，还需要判断顶上的是否是一个数字。。
public class FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedIntegerList) {
        for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {               // 注意这里是从最后开始的，因为是stack
            stack.push(nestedIntegerList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
    }

    // 这个同时有flatten的功能，不只是找hasNext
    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            NestedInteger list = stack.pop();
            for (int i = list.getList().size() - 1; i >= 0; i--) {      // 注意这里是从最后开始的因为是stack
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
