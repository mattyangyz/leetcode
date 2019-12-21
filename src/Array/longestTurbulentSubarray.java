package Array;

/**
 * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
 * <p>
 * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
 * OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
 * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
 * <p>
 * Return the length of a maximum size turbulent subarray of A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [9,4,2,10,7,8,8,1,9]
 * Output: 5
 * Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
 * Example 2:
 * <p>
 * Input: [4,8,12,16]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [100]
 * Output: 1
 * <p>
 * 思路: 用交替的思想去想。
 */

public class longestTurbulentSubarray {

    public int maxTurbulenceSize(int[] A) {
        int inc = 1;
        int dec = 1;
        int result = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                // 这里必须交替进行
                dec = inc + 1;
                // 这里设成 1 是因为，免得下次进来的时候再累加之前正确的结果
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(inc, dec));
        }
        return result;
    }
}
