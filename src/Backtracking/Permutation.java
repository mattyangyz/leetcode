package Backtracking;

import java.util.ArrayList;
import java.util.List;

//backtracking
//[1,2,3], [3,2,1], [2,1,3]
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
                if (candidate.contains(nums[i])) {
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