package BinarySearch;


/**
 * Linkedin TODO: NOT YET UNDERSTAND
 */

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] a, char target) {

        int low = 0;
        int high = a.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (a[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return target >= a[low] ? a[0] : a[low];
    }
}
