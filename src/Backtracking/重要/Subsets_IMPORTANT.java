package Backtracking.重要;

import java.util.ArrayList;
import java.util.List;


// backtracking
// [1,2,3] -> [], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]
public class Subsets_IMPORTANT {

    public static List<List<Integer>> subsets(int[] array) {
        List<List<Integer>> ans = new ArrayList<>();

        if (array == null) {
            return ans;
        }
        backtrack(array, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] array, int index, List<Integer> temp, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(temp));
        for (int i = index; i < array.length; i++) {
            temp.add(array[i]);
            backtrack(array, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}

