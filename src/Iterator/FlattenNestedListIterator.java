package Iterator;

import Tree.DFS.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Need to review.
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

public class FlattenNestedListIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public FlattenNestedListIterator(List<NestedInteger> nestedIntegerList) {
        for (int i = nestedIntegerList.size() - 1; i >= 0; i--) {
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

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            NestedInteger list = stack.pop();
            for (int i = list.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
