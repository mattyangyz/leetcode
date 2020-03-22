package MathRelated;

/**
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequence:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 * <p>
 * <p>
 * Example:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * <p>
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * return : 3 for 3 arithmetic slices in A [1, 2, 3], [2, 3, 4], [1,2,3,4]
 * <p>
 * <p>
 * 数组                res            与上一数组的数目比较
 * [1, 2, 3]            1           1-0 = 1
 * [1, 2, 3, 4]         3           3-1 = 2
 * [1, 2, 3, 4, 5]      6           6-3 = 3
 * [1, 2, 3, 4, 5, 6]   10          10-6 = 4
 * <p>
 * 思路: 没什么算法 就是暴力解
 */

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0;
        int res = 0;

        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
