package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }

    private static void subsetsWithDupHelper(int[] nums, int index, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]){  // avoid dup here.
                continue;
            }
            temp.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
