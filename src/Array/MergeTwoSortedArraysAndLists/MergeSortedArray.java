package Array.MergeTwoSortedArraysAndLists;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * 思路: 不能简单的用一个while(firstIndex >= 0 && secondIndex >= 0)，加两个 if(firstIndex < 0) 和 if(secondIndex < 0)。
 * 想想 first = {0}, 0 second = {1}, 1这种情况。
 */

public class MergeSortedArray {

    public static void merge(int[] first, int m, int[] second, int n) {

        int insertIndex = m + n - 1;
        int firstIndex = m - 1;
        int secondIndex = n - 1;

        while (firstIndex >= 0 && secondIndex >= 0) {
            first[insertIndex--] = first[firstIndex] > second[secondIndex] ? first[firstIndex--] : second[secondIndex--];
        }

        while (secondIndex >= 0) {                      // 不用考虑 firstIndex >= 0的情况，因为如果是那样的话，就不用挪了， 因为它本来就是有序的。
            first[insertIndex--] = second[secondIndex--];
        }
    }
}
