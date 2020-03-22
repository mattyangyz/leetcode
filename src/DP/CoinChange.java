package DP;


/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * 思路: 利用一个跟amount值一样大的一维数组去记录最优解，不需要二维数组的。
 */

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {

            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; i < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE) {
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
                }
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minNumber[amount];
        }
    }
}
