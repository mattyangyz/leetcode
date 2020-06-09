package Backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */

// 标准的backtracking写法。 不过要考虑第一个element怎么加进去，而且当前element是要跟partial result里的东西去比较的。
public class IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> partialRes = new ArrayList<>();
        backtracking(res, partialRes, 0, nums);
        List<List<Integer>> list = new ArrayList<>(res);
        return list;
    }

    public void backtracking(Set<List<Integer>> set, List<Integer> partialRes, int index, int[] nums) {
        if (partialRes.size() > 2) {
            set.add(new ArrayList<>(partialRes));
        }

        for (int i = index; i < nums.length; i++) {
            if (partialRes.size() == 0 || nums[i] >= partialRes.get(partialRes.size() - 1)) {
                partialRes.add(nums[i]);                                                        // standard backtracking.
                backtracking(set, partialRes, i + 1, nums);
                partialRes.remove(partialRes.size() - 1);
            }
        }
    }

}
