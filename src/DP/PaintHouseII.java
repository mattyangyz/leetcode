package DP;


/**
 * Linkedin
 * <p>
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each
 * house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example,
 * costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * <p>
 * 思路: 我们只需要keep track min1跟min2 就行啦，如果当前index跟min1一样 则取min2。 两个loop， 注意怎么在第二个loop
 * 里面 在计算每一个颜色的value的时候同时计算min1 跟 min2 ->用额外的var去实现， 记住这两个var都是index而不是实际的最小值。
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int length = costs.length;
        int k = costs[0].length;

        int min1 = -1;
        int min2 = -1;

        for (int i = 0; i < length; i++) {

            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;

            for (int j = 0; j < k; j++) {
                if (i != 0) {                                    // first row does NOT need to calculate the value
                    if (j != last1) {                           // current color j is different to last min1 color
                        costs[i][j] += costs[i - 1][last1];
                    } else {
                        costs[i][j] += costs[i - 1][last2];
                    }
                }
                if (min1 < 0 || costs[i][j] < costs[i][min1]) { // find the indices of 1st and 2nd smallest cost of painting current house 1
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }

        }
        return costs[length - 1][min1];
    }
}
