package MathRelated;

import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
 * Example 1:
 * Input: ["23:59","00:00"]
 * Output: 1
 * Note:
 * The number of time points in the given list is at least 2 and won't exceed 20000.
 * The input time is legal and ranges from 00:00 to 23:59.
 * <p>
 * 意思: 一堆时间里面找出最小的diff。
 * 关键点找出最大和最小的，因为这两个是关键点 最大和最小的需要两边算， 其他的只需要算一个direction就行了。】
 * 画出坐标轴就能理解了。
 * <p>
 * 2020-JUN-10
 */

// 刻度坐标是以分钟计的，这个要记住。
public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {

        boolean[] mark = new boolean[24 * 60];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String time : timePoints) {
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]);
            int minute = Integer.parseInt(t[1]);
            if (mark[hour * 60 + minute]) {
                return 0;
            }
            min = Math.min(min, hour * 60 + minute); //一堆数里面找出min和max
            max = Math.max(max, hour * 60 + minute);
            mark[hour * 60 + minute] = true;
        }

        int minDiff = Integer.MAX_VALUE;
        int prev = 0;

        for (int i = min; i <= max; i++) {
            if (mark[i]) {
                if (i == min) {           // 重点是这里
                    //the min and max is the special case, it looks like :
                    //0---min----max-----1440, so we have two directions to calculate the distance
                    minDiff = Math.min(minDiff, Math.min(max - min, 1440 - max + min));
                } else {
                    //normal case: just one direction.
                    minDiff = Math.min(minDiff, i - prev);
                }
                prev = i;
            }
        }

        return minDiff;
    }
}
