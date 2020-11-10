package Hard;


/**
 *
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible,
 * it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples.
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 1， 2， 7， 4， 3， 1
 *
 */


//思路 1. 从右边开始找第一个pair，前面的数比后面的要小的。2. 然后再从右边往左边找，找第一个比 firstSmallIndex大的数
// 3. 然后再从firstSmallIndex那里给reverse一下。
// 因为permute是从右边开始变换的，所以是从右边开始

// 1 2 3 4 5 10 9 8 第一个右边从左边开始比较小的数，为什么要找1.第一个小的数呢，因为考虑一下permute是则呢么generate的过程就知道了
// 1 2 3 4 5 10 6 8 第一个右边从左边开始比较小的数

// 2. 为什么要找2. 从右边开始找 找第一个比firstSmall大的数跟firstSmallIndex交换，为什么呢，因为题目要求是next greater permutation。
// 3. 为什么要执行第三部的reverse呢，因为根据1就是到此时 firstsmallindex右边都是比它大的，而且是一个由smallindex从左到右单调递减的subarray
// 我们要把它变成从左到右单调递增的，这样就符合题目要求next greater permutation了。
// twoPointer
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int firstSmallIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                firstSmallIndex = i - 1;
                break;
            }
        }

        if (firstSmallIndex == -1) {                    // 整个array就是一个倒叙排列的
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmallIndex; i--) {   // 再从右往左找第一个比 firstSmallIndex 大的数
            if (nums[i] > nums[firstSmallIndex]) {
                firstLarge = i;
                break;
            }
        }

        swap(nums, firstSmallIndex, firstLarge);
        reverse(nums, firstSmallIndex + 1, nums.length - 1);
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
