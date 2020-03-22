package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 315. Count of Smaller Numbers After Self
 * Hard
 * <p>
 * 1842
 * <p>
 * 71
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * <p>
 * 思路: 用一个而外的array去记录相应的insert index，这个index就代表前面有多少数是小于这个current的。
 * <p>
 * 比如 1 2 6 -> 当计算到5的时候， index为2 代表前面有两个数是小于5的。 这个2的index应该用标准的binary search去找出来。
 * <p>
 * 时间复杂度O(N^2) 平均是O(nlogn)
 * 空间复杂度是O(n)
 */


public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;                     // 相应地也要从后面开始 不能从前面开始
            list.add(index, nums[i]);
        }

        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) {
            return 0;
        }
        int start = 0;
        int end = list.size() - 1;
        if (target > list.get(end)) {
            return end + 1;
        }
        if (list.get(start) >= target) {
            return 0;
        }

        while (start <= end) {                    // 这个是标准的binary search
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (list.get(start) >= target) {
            return start;
        }
        return end;
    }
}
