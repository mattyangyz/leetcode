package Array.MergeTwoSortedArraysAndLists;

/**
 * Given two sorted arrays, the task is to merge them in a sorted manner.
 */

public class MergeTwoSortedArrays {

    public void mergeArrays(int[] arr1, int n, int[] arr2, int m, int[] arr3) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr1[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while (i < n) {
            arr3[k++] = arr1[i++];
        }
        while (j < m) {
            arr3[k++] = arr2[j++];
        }
    }
}
