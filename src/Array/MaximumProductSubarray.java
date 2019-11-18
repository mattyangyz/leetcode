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
 * 思路： 必须维持一个最大跟最小的，因为负负得正 正负得负。所以两种都有可能。
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
            int tempMax = maxHere;
            maxHere = Math.max(Math.max(maxHere * a[i], minHere * a[i]), a[i]);
            minHere = Math.min(Math.min(tempMax * a[i], minHere * a[i]), a[i]);
            maxSoFar = Math.max(maxHere, maxSoFar);
        }
        return maxSoFar;
    }
}


