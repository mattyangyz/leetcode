package Array.TopKBucketSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Similar 692. Top K Frequent Words and 451. Sort Characters By Frequency
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * 我们还可以使用桶排序，在建立好数字和其出现次数的映射后，
 * 我们按照其出现次数将数字放到对应的位置中去，这样我们从桶的后面向前面遍历，最先得到的就是出现次数最多的数字，我们找到k个后返回即可
 * <p>
 * 思路： 找前k个出现次数最高的元素。
 * 用Bucket sort来做，时间复杂度O(n).
 * 1. 先遍历一次，用hashmap建立数字-> 出现次数的map。
 * 2. 创建bucket, 每个bucket都是一个List，把次数放入对应序号的bucket里面.
 * 3.对bucket从后往前遍历，把适合条件的元素放入最后集合list.
 *
 * 但是这里有bug， [4,1,-1,2,-1,2,3] k = 3，it should return 所有五个元素，但是在这题里面只return了-1, 2. 这里需要问
 * 清楚面试官, 问清楚是 k most of frequency 还是 k most of the result.
 *
 *
 * 注意这里要读。
 * Think about the case when K=2,
 * and you have 1 number that has max frequency, say 10 times.
 * and you have 10 numbers that has 2nd max frequency, say 9 times.
 * the returned int should be size 2 not 11.
 *
 */

public class TopKFrequentElement {

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int n : map.keySet()) {
            int frequency = map.get(n);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(n);
        }                                                                // 上面两个loop都是bucket sort的套路

        int[] res = new int[k];
        int count = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {                    // 遍历每一个bucket，
            if (bucket[i] != null) {

                for (int j = 0; j < bucket[i].size() && count < k; j++) {    // 遍历每个bucket里面的list
                    res[count] = bucket[i].get(j);
                    count++;
                }
            }
        }
        return res;
    }
}
