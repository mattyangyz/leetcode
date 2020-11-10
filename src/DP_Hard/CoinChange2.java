package DP_Hard;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 * <p>
 * <p>
 * Note:
 * <p>
 * You can assume that
 * <p>
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * <p>
 * 思路: m[i][j] 表示到index j amount那里， index i前面的所有硬币的个数。
 * <p>
 * 0, 1, 2, 3, 4, 5, 6
 * 0  1  0  0  0  0  0  0
 * 1  1
 * 3  1
 * 5  1
 */

public class CoinChange2 {

    public static int change(int amount, int[] coins) {

        int[][] memp = new int[coins.length + 1][amount + 1];

        memp[0][0] = 1;

        for (int i = 1; i < memp.length; i++) {
            memp[i][0] = 1;                         // set first row.

            for (int j = 1; j < memp[0].length; j++) {
                if (j >= coins[i - 1]) {              // 用当前coin，取之前的结果的时候必须减去现在coin的面值coins[i -1]
                    memp[i][j] = memp[i - 1][j] + memp[i][j - coins[i - 1]];
                } else {                               // 不用当前coin
                    memp[i][j] = memp[i - 1][j];
                }
            }
        }
        return memp[coins.length][amount];
    }
}
