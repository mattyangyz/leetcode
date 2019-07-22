package Tree.Preorder.DFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;


/**
 * Companies: LinkedIn
 */

/**
 *
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 *
 *
 */

public class NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedIntegerList) {


        int prevSum = 0;
        int totalSum = 0;

        Deque<NestedInteger> queue = new ArrayDeque<>();

        for (NestedInteger ni : nestedIntegerList) {
            queue.offerLast(ni);
        }

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.pollFirst();
                if (current.isInteger()) {
                    levelSum += current.getInteger();
                } else {
                    queue.addAll(current.getList());
                }
            }
            prevSum += levelSum;
            totalSum += prevSum;
        }
        return totalSum;
    }

}
