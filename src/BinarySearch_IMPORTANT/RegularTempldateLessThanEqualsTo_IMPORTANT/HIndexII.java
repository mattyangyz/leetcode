package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 * Note:
 * <p>
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * <p>
 * 思路: 传统binary search模板
 * <p>
 * 利用binary search去做, [0, 1, 3, 5, 5, 6, 8] 一开始mid落在第一个5那里，然后citation[3] > 4， 所以right就等于mid - 1 = 2了
 * 然后下一个loop，然后citation[2] < 4了，然后left就等于mid + 1也就是3.然后loop就停止了。left最后停在的位置是不满足条件的第一个index
 * 上面。
 */

public class HIndexII {

    public int hIndex(int[] citations) {
        int length = citations.length;
        int left = 0;
        int right = citations.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (citations[mid] == length - mid) {
                return length - mid;
            } else if (citations[mid] < length - mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // left最后会停在第一个不满足条件的index
        return length - left; // 这里可以直接length - left，因为left是由0开始的
    }
}
