package Greedy;


import java.util.Arrays;

/**
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * <p>
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * <p>
 * <p>
 * 思路: 用(a[0] - a[1]) - (b[0] - b[1])进行排序， 然后越小的说明到A更近，那就先让这些人去A先，剩下的后半部分到B去。
 */

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });
        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                ans += costs[i][0];
            } else {
                ans += costs[i][1];
            }
        }
        return ans;
    }

}
