package Backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combination(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    public void combination(List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
        if (comb.size() == k && n == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, start + 1, n - i);
            comb.remove(comb.size() - 1);
        }
    }
}
