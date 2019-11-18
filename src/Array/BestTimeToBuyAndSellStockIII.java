package Array;


/**
 * 卖完第一次以后， 第二次买的成本就是减去第一次的利润， 这样就能把第一次买的利润转移到第二次买里面去（第二次买的成本会减少），
 * 当twoBuyTwoSell就会增加利润
 * <p>
 * 重点理解 [1,2,3,4,5]， 可以理解为1的时候买第一次，4卖出，然后4马上又买进(两次)， 5卖出， 或1买进 5卖出(一次)。
 * <p>
 * Here, the oneBuy keeps track of the lowest price, and oneBuyOneSell keeps track of the biggest profit we could get.
 * Then the tricky part comes, how to handle the twoBuy? Suppose in real life,
 * you have bought and sold a stock and made $100 dollar profit.
 * When you want to purchase a stock which costs you $300 dollars,
 * how would you think this? You must think, um, I have made $100 profit,
 * so I think this $300 dollar stock is worth $200 FOR ME since I have hold $100 for free.
 * There we go, you got the idea how we calculate twoBuy!! We just minimize the cost again!!
 * The twoBuyTwoSell is just making as much profit as possible.
 * Hope this explanation helps other people to understand this!
 * <p>
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStockIII {

    public int maxPrice(int[] prices) {

        int oneBuyOneSell = 0;
        int twoBuyTwoSell = 0;

        int oneBuy = Integer.MAX_VALUE;
        int twoBuy = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            oneBuy = Math.min(oneBuy, prices[i]);
            oneBuyOneSell = Math.max(oneBuyOneSell, prices[i] - oneBuy);

            twoBuy = Math.min(twoBuy, prices[i] - oneBuyOneSell);
            twoBuyTwoSell = Math.max(twoBuyTwoSell, prices[i] - twoBuy);
        }
        return twoBuyTwoSell;
    }
}
