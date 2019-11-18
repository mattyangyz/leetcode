package Array;


/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * 如果当前价格比已知最小的小， 取当前价格为最小。如果当前价格减去最小价格大于最大利润， 则更新最大利润。
 *
 */

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] nums) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int num : nums) {
            if (num < minPrice) {
                minPrice = num;
            } else {
                maxProfit = Math.max(num - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }
}
