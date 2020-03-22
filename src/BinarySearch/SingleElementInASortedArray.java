package BinarySearch;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * 意思: 看例子 1 1 2 3 3 4 4 5 5 6 6 7 7
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 -> 如果是invalid的话 偶数是第二个，基数是其他不一样的
 * <p>
 * 1 1 2 2 3 3 4 4 5 5 6 6 7
 * *        0 1 2 3 4 5 6 7 8 9 10 11 12 -> 如果是valid的话 偶数是第一个，基数是第二个
 * <p>
 * target number 只会出现在偶数的index上面，但是计算出来的mid会包含基数偶数，所以要判断
 * 是基数还是偶数 然后进行相应的increment。
 */

public class SingleElementInASortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;       // 这里不能减一，不然最后的两个element在下面的操作后就会被skip

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 2;            // 在第一个pair那里 所以需要加2
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1;            // 在第二个pair那里 所以需要加1
                } else {
                    end = mid;
                }
            }

        }
        return nums[start];
    }
}
