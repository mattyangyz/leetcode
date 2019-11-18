package Array.Range;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 关键要lower - 1， 当curr等于upper的时候
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 *
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 *
 * 用一个指针prev记录上次range的结尾，另外一个指针curr。 如果prev 跟 curr大于1， 说明一个missing range。
 *
 * 需要考虑三种情况 1. 如何处理lower刀第一个数 和 最后一个数刀upper missing rnage.
 *
 *
 */

public class MissingRange {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();

        if (nums == null || nums.length == 0) {
            res.add(getRanges(lower, upper));
            return res;
        }
        long prev = lower - 1;
        long curr = 0;
        for (int i = 0; i <= nums.length; i++) {

            // upper + 1 是处理 upper range用的 包括upper range
            curr = (i == nums.length) ? upper + 1 : nums[i];
            if (curr - prev > 1) {
                res.add(getRanges(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return res;
    }

    private String getRanges(long from, long to) {
        return from == to ? String.valueOf(from) : from + "->" + to;
    }
}
