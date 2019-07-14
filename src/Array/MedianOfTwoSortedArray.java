package Array;

/**
 * 这题用了binary search， 但是跟平时的不一样 不一样的地方在于while是cut1 <= nums1.length
 *
 * index 0   1   2   3   4   5
 *
 * num1: 3   5   8   9
 *
 * num2: 1   2   7   10  11  12
 *
 */

public class MedianOfTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int length = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = length / 2 - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = cut1 == 0 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == 0 ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 > r2){
                cutR = cut1 - 1;
            }
            else if(l2 > r1){
                cutL = cut1 + 1;
            }
            else{
                if (length % 2 == 0) {
                    l1 = l1 > l2 ? l1 : l2;
                    r1 = r1 < r2 ? r1 : r2;
                    return (l1 + r1) / 2;
                }
                else{
                    r1 = r1 < r2 ? r1 : r2;
                    return r1;
                }
            }
        }
        return -1;
    }
}
