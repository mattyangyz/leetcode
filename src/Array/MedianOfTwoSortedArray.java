package Array;

/**
 *
 *
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 *
 * 基数取中间
 * 偶数取左右两个值得平均值 （* 0.5）
 *
 * 这题用了binary search， 但是跟平时的不一样 不一样的地方在于while是cut1 <= nums1.length
 *
 * index 0   1   2   3   4   5
 *
 * num1: 3   5  ||  8   9               cut 1
 *           L1     L2
 *
 * num2: 1   2   7  ||  10  11  12      cut 2
 *               R1     R2
 *
 * 切完num1之后就知道num2怎么切！！为什么是log呢，因为切的时候 可以用binary来切
 *
 * index 0    1    2    3   4   5
 *
 *       26   40  80    90
 *       20   25  27.5  70
 *
 * FACT::: L1 <= R2 AND L2 <= R1
 *
 * if(L1 > R2) CUT1 <<   (CutL, cut1 - 1)
 * if(L2 > R1) CUT2 >>   (Cut1 + 1, cutR)
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

        int cutL = 0;                   // cut1 是cutL 跟 cutR的范围里面决定的
        int cutR = nums1.length;

        while (cut1 <= nums1.length) {  // cut 1 需要小于 nums1.length 而不是left < right， 这不是传统的binary search patern
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = length / 2 - cut1;   // 知道cut1是哪里cut之后 就能确定cut2在哪

            double L1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1]; // 因为index是0开始 所以减一
            double L2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            //判断是否合法 满足 L1 <= R2 AND L2 <= R1

            if (L1 > R2) {
                cutR = cut1 - 1;            // 这里是binary！！！！
            } else if (L2 > R1) {
                cutL = cut1 + 1;
            } else {
                if (length % 2 == 0) {
                    L1 = L1 > L2 ? L1 : L2; // 左边的最大值
                    R1 = R1 < R2 ? R1 : R2; // 右边的最小值
                    return (L1 + R1) / 2;
                }
                else{
                    R1 = R1 < R2 ? R1 : R2; // 如果是基数的话，永远都是右边的最小值
                    return R1;
                }
            }
        }
        return -1;
    }
}
