package BucketSort;

/**
 *
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 *
 * 思路: 把对应的value放到相应的index里面去，比如 3 4 -1 1 放成 1，-1，3 4 对于 -1 和 大于nums.length的数字不需要考虑把他们放到相应的index去。
 * 最后历遍这个array看有哪个index的值没有对应上index number这个就是第一个missing number。
 *
 * runtime分析: We visit each number once, and each number will be put in its right place at most once,
 * so it is O(n) + O(n). Although there are two nesting of cyclic (for and while), but its time complexity is still O(n).
 */

// https://www.youtube.com/watch?v=cG1rZPIo3ww
public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive.firstMissingPositive(new int[]{12, 11, 10, 9, 8});
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {

            // 这里必须用while，考虑 3 4 -1 1 这种情况， 第一次 for loop结束后变成 -1 4 3 1， 第二次 for loop后变成 -1 1 3 4
            // 即使 3 和 4 的位置对了 但是1的位置还没有对 所以要继续用while loop处理。因为一旦i 过了之前的就没办法再处理了
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){               // 这里的 <= 变成 < 也是可以的。
                FirstMissingPositive.swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // no positive numbers were found, which means the array contains all numbers 1..n
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
