package DP_Hard;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * <p>
 * 思路: 假设最小公式值m = ƒ(n)
 * 那么n的值满足下列公式 ∑(A[i] * A[i]) = n
 * 令 k 为满足最小值 m 的时候，最大的平方数  。 令  d + k * k; = n ;  d >= 0;
 * 注意：一定要是满足m最小的时候的k值,一味的取最大平方数,就是贪心算法了
 * 得出 f(d) + f(k*k) = f(n);
 * 显然 f(k*k) = 1; 则  f(d) + 1 = f(n); 因为 d = n - k*k;
 * 则可以推出ƒ(n - k * k) + 1 = ƒ(n) ;  且 k * k <= n;
 */

public class PerfectSquares {

    public int numSquares(int n) {
        int[] memp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            memp[i] = i;

            for (int j = 1; i - j * j >= 0; j++) { // 这个i - j * j理解成分成两半，一般是 i - j * j 一半是 j * j

                memp[i] = Math.min(memp[i], memp[i - j * j] + 1);
            }
        }
        return memp[n];
    }
}
