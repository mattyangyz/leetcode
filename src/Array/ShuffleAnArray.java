package Array;

import java.util.Random;

/**
 * 需要加深理解。
 * <p>
 * Shuffle a set of numbers without duplicates.
 * <p>
 * Example:
 * <p>
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 * <p>
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 * <p>
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 * <p>
 * <p>
 * 思路: Fisher–Yates shuffle Algorithm works in O(n) time complexity.
 * The assumption here is, we are given a function rand() that generates random number in O(1) time.
 * The idea is to start from the last element,
 * swap it with a randomly selected element from the whole array (including last).
 * Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element.
 * <p>
 * https://www.youtube.com/watch?v=tLxBwSL3lPQ
 */

public class ShuffleAnArray {
    private int[] nums;
    private Random r = new Random();

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] res = nums.clone();

        for (int i = nums.length - 1; i > 0; i--) {
            int random = r.nextInt(i + 1);
            swap(res, i, random);
        }
        return res;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
