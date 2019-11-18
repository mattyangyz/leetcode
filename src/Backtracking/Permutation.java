package Backtracking;

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
 */
public class Permutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, List<Integer> candidate, int[] nums) {
        if (candidate.size() == nums.length) {
            System.out.println(candidate);
            ans.add(new ArrayList<>(candidate));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (candidate.contains(nums[i])) {                  // 这里是关键， 有了这里 i 就可以每次都从 i = 0开始，这是是O(N
                    continue;
                } else {
                    candidate.add(nums[i]);
                    backtrack(ans, candidate, nums);
                    candidate.remove(candidate.size() - 1);
                }
            }
        }
    }
}