package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

    public static List<List<Integer>> getFactor(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(n, 2, result, list);
        return result;
    }

    public static void helper(int n, int start, List<List<Integer>> result, List<Integer> curr) {
        if (n == 1) {
            result.add(new ArrayList<>(curr));
        }
        else{
            for (int i = start; i < n; i++) {
                if (n % i == 0) {
                    curr.add(i);
                    helper(n / i, i, result, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
