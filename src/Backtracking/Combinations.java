package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Input: n = 4, k = 2
 *
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */

public class Combinations {

    public static void main(String[] args) {
        System.out.println(Combinations.combine(4, 3));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> ans, List<Integer> temp, int start, int n, int k) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            combine(ans, temp, i + 1, n, k - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
