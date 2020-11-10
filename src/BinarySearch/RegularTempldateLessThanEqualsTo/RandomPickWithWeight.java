package BinarySearch.RegularTempldateLessThanEqualsTo;


import java.util.Random;

/**
 *
 *
 * Given an array w of positive integers, where w[i] describes the weight of index i(0-indexed), write a function pickIndex which randomly picks an index in proportion to its weight.
 *
 * For example, given an input list of values w = [2, 8], when we pick up a number out of it, the chance is that 8 times out of 10 we should pick the number 1 as the answer since it's the second element of the array (w[1] = 8).
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output
 * [null,0]
 *
 * Explanation
 * Solution solution = new Solution([1]);
 * solution.pickIndex(); // return 0. Since there is only one single element on the array the only option is to return the first element.
 * Example 2:
 *
 * Input
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output
 * [null,1,1,1,1,0]
 *
 * Explanation
 * Solution solution = new Solution([1, 3]);
 * solution.pickIndex(); // return 1. It's returning the second element (index = 1) that has probability of 3/4.
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 1
 * solution.pickIndex(); // return 0. It's returning the first element (index = 0) that has probability of 1/4.
 *
 * Since this is a randomization problem, multiple answers are allowed so the following outputs can be considered correct :
 * [null,1,1,1,1,0]
 * [null,1,1,1,1,1]
 * [null,1,1,1,0,0]
 * [null,1,1,1,0,1]
 * [null,1,0,1,0,0]
 * ......
 * and so on.
 *
 *
 * Constraints:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 *
 * 思路: 用累加和 + random + 正常的binary search去做。
 * <p>
 * 8, 1, 2, 10 -> sum: 8, 9, 11, 21 就是有 8/21的机会选到index0， 1/21的机会选到index1。
 * <p>
 * 记住: randomNum = rand.nextInt((max - min) + 1) + min;
 *
 *
 */


// 8 1 2 10, 累加和是 8 9 11 21， 就是从0-8都是属于第一区间的，9就属于第二区间的。返回的时候是返回这些区间的index
// 需要注意的是 返回的时候一定要返回 mid 也就是而不能是randomNumber。
public class RandomPickWithWeight {

    Random random;
    int[] sum;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }

    public int pickIndex() {
        int randomNumber = random.nextInt(sum[sum.length - 1]) + 1;

        int left = 0;
        int right = sum.length - 1;

        while (left <= right) {                              // 正常的binary search
            int mid = left + (right - left) / 2;
            if (sum[mid] == randomNumber) {
                return mid;
            } else if (sum[mid] < randomNumber) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
