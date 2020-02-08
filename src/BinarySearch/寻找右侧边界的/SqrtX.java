package BinarySearch.寻找右侧边界的;


/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 * the decimal part is truncated, 2 is returned.
 * <p>
 * <p>
 * 思路: 我们要找的ans是要最接近于X的最大的数，所以是upper bound.
 */
public class SqrtX {

    public int mySqrtRegular(int x) {
        int left = 1;
        int right = x;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {      // 如果刚好 mid * mid = x 代表这个就是结果
                return mid;
            }
            if (mid * mid < x) {
                left = mid + 1;
            } else {               // 当这个 mid * mid > x的时候，我们需要把upper bound往👈移动 才能得到 mid*mid <= x的数
                right = mid;
            }
        }
        return left - 1;    // 如果是8的话，最后的left和right都是3
    }
}
