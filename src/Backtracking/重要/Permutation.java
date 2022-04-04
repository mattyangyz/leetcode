package Backtracking.重要;

import java.util.ArrayList;
import java.util.List;

//backtracking

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * O(n! * n) 空间O(n)
 *
 * // distinct是关键。 这题的关键是怎么避免出现， 1 1 1 或者 1 3 2 (1 2 3 已经出现过了)
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> candidate, int[] nums) {
        if (candidate.size() == nums.length) {
            ans.add(new ArrayList<>(candidate));    // 这里一定要是一个新的arrayList。
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!candidate.contains(nums[i])) {                  // 这里是关键
                    candidate.add(nums[i]);
                    backtrack(ans, candidate, nums);
                    candidate.remove(candidate.size() - 1);
                }
            }
        }
    }
}