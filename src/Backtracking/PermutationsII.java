package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {


    public static List<List<Integer>> permutationUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {

        if (list.size() == nums.length) {
            System.out.println(list.toString());
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}