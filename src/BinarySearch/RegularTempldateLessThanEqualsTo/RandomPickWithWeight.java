package BinarySearch.RegularTempldateLessThanEqualsTo;


import java.util.Random;

/**
 * 思路: 用累加和 + random + 正常的binary search去做。
 * <p>
 * 8, 1, 2, 10 -> sum: 8, 9, 11, 21 就是有 8/21的机会选到index0， 1/21的机会选到index1。
 * <p>
 * 记住: randomNum = rand.nextInt((max - min) + 1) + min;
 */

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
        int index = random.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left <= right) {                              // 正常的binary search
            int mid = left + (right - left) / 2;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
