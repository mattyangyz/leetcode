package MergeSort;


/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 * <p>
 * You need to return the number of important reverse pairs in the given array.
 * <p>
 * Example1:
 * <p>
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 * <p>
 * Input: [2,4,3,5,1]
 * Output: 3
 * Note:
 * The length of the given array will not exceed 50,000.
 * All the numbers in the input array are in the range of 32-bit integer.
 * <p>
 * 思路：用merge sort去做，因为merge sort可以设计到divide一个array或是subarray为两半，
 * 然后再这两半里面就可以进行一个比较了。用first half跟second half去比较。
 * 比较完后记得把这一部分的element给sort了，这样的话下一次比较的时候就可以利用上。
 * 最后记得把这个sort完的element放回到原来的nums array里面。
 */

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int res = 0;

        res += mergeSort(nums, low, mid);
        res += mergeSort(nums, mid + 1, high);
        res += merge(nums, low, mid, high);
        return res;
    }

    private int merge(int[] nums, int low, int mid, int high) {

        int count = 0;
        int[] a = new int[high - low + 1];

        int firstHalf = low;
        int secondHalf = mid + 1;

        while (firstHalf <= mid && secondHalf <= high) {
            if ((long) nums[firstHalf] > 2 * (long) nums[secondHalf]) {
                count += mid - firstHalf + 1;   // 1 3 4 5 // 1 2 当firstHalf等于3的时候既然已经大于右边的1
                // 所以后面的 4 5 都会大于 所以不需要再比较 直接mid - firstHalf 得到就行了
                secondHalf++;
            } else {
                firstHalf++;
            }
        }

        firstHalf = low;
        secondHalf = mid + 1;
        int insertIndex = 0;

        // 真正地sort array，然后放入回原来的array里面
        while (firstHalf < mid && secondHalf <= high) {
            if (nums[firstHalf] > nums[secondHalf]) {
                a[insertIndex++] = nums[secondHalf++];
            } else {
                a[insertIndex++] = nums[firstHalf++];
            }
        }

        while (firstHalf <= mid) {
            a[insertIndex++] = nums[firstHalf++];
        }

        while (secondHalf <= high) {
            a[insertIndex++] = nums[secondHalf++];
        }

        System.arraycopy(a, 0, nums, low, high - low + 1);
        return count;
    }
}
