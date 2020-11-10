package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 思路： 跟permutation是一样的，只是这里要处理dup的情况。 https://ibb.co/k4zv00 , https://ibb.co/ncMm7f
 *
 * 要理解怎么去dup，先把array sort了，然后再用一个visited的array去存看过的元素。
 *
 */
public class PermutationsII {

    public static void main(String[] args) {
        PermutationsII.permutationUnique(new int[]{1, 2, 2});
    }

    public static List<List<Integer>> permutationUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {                                                    // 这个看这个数有没有用过
                continue;
            }
            // 1 2 2' with used[i - 1] == false, it will add the 1 2 2' immediate
            // but not enter 1  2' 2.. Think about this.
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == true) {    // [1,2,2] -> 想想
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
