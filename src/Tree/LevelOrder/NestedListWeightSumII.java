package Tree.LevelOrder;

import Tree.DFS.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Linkedin review 1
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
 * Input: [1,[4,[5]]]
 * Output: 17
 * Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 5*1 = 16.
 *
 *
 *
 * total: sum 1
 * preSum 1
 *
 * 1
 * 5
 * 6
 *
 *
 *

 */

public class NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedIntegerList) {
        int singleSum = 0;
        int totalSum = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedIntegerList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                    singleSum += current.getInteger();
                } else {
                    queue.addAll(current.getList());
                }
            }
            totalSum += singleSum;
        }
        return totalSum;
    }
}
