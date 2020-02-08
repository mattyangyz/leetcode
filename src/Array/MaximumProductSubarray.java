package Array;


/**
 * 固定第一个为最大跟最小， 然后也是maxSoFar， 然后从第二个开始treverse。。。要考虑当负负得正的情况
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * 思路： 必须维持一个最大跟最小的，因为负负得正 正负得负。所以两种都有可能
 *
 * this is very similar to the " max cumulative sum subarray" problem. here you keep 2 values:
 * the max cumulative product UP TO current element starting from SOMEWHERE in the past,
 * and the minimum cumuliative product UP TO current element .
 * it would be easier to see the DP structure if we store these 2 values for each index,
 * like maxProduct[i],minProduct[i] .
 *
 * at each new element, u could either add the new element to the existing product,
 * or start fresh the product from current index (wipe out previous results), hence the 2 Math.max() lines.
 *
 * if we see a negative number, the "candidate" for max should instead become the previous min product,
 * because a bigger number multiplied by negative becomes smaller, hence the swap()
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int maxHere = a[0];
        int minHere = a[0];
        int maxSoFar = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < 0) {
                int temp = maxHere;
                maxHere = minHere;
                minHere = temp;
            }

            maxHere = Math.max(maxHere * a[i], a[i]);   // a[i]有可能是0.5, 必须是maxHere * a[i]跟a[i]比较
            minHere = Math.min(minHere * a[i], a[i]);
            maxSoFar = Math.max(maxSoFar, maxHere);
        }
        return maxSoFar;
    }
}


