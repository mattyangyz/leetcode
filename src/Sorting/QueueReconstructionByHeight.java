package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * <p>
 * Note:
 * The number of people is less than 1,100.
 * <p>
 * <p>
 * Example
 * <p>
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * <p>
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * <p>
 * 思路: We first sort the people to make them stand from the highest to shortest.
 * For people with same height, sort them according to the count of people before them from small to big.
 * <p>
 * Then, we use the way similar to insert sorting to reorder the people.
 * For a given person to insert, all the people already sorted are higher,
 * so we just insert him in the "right" place to make the people before him as his "count" indicates.
 * Since he is shorter than all the people in the sorted list,
 * the "count" of the "existing" people does not be broken by the insertion.
 * <p>
 * 先从大到小进行排序，防止遇到[7,0], [5,0] 这样的情况时候发生7,0],[5,0]的情况，正确的应该是[5,0],[7,0]。
 * <p>
 * 时间o(n^2)
 */

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) ->
                a[0] == b[0] ? (a[1] - b[1]) : (b[0] - a[0])); // b[0] - a[0]是大到小排列

        ArrayList<int[]> list = new ArrayList<>();
        for (int[] cur : people) {
            list.add(cur[1], cur);                  // 这个add是o(n) 所以n个元素就是o(n^2)
        }


        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
