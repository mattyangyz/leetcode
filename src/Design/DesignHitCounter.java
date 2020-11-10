package Design;

/**
 * /** Linkedin
 * *
 * * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * *
 * * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are
 * being made to the system in chronological order (ie, the timestamp is monotonically increasing).
 * You may assume that the earliest timestamp starts at 1.
 * *
 * * It is possible that several hits arrive roughly at the same time.
 * *
 * * Example:
 * *
 * * HitCounter counter = new HitCounter();
 * *
 * * // hit at timestamp 1.
 * * counter.hit(1);
 * *
 * * // hit at timestamp 2.
 * * counter.hit(2);
 * *
 * * // hit at timestamp 3.
 * * counter.hit(3);
 * *
 * * // get hits at timestamp 4, should return 3.
 * * counter.getHits(4);
 * *
 * * // hit at timestamp 300.
 * * counter.hit(300);
 * *
 * * // get hits at timestamp 300, should return 4.
 * * counter.getHits(300);
 * *
 * * // get hits at timestamp 301, should return 3.
 * * counter.getHits(301);
 * * Follow up:
 * * What if the number of hits per second could be very large? Does your design scale?
 * *
 *
 * 思路: 这道题让我们设计一个点击计数器，能够返回五分钟内的点击数，提示了有可能同一时间内有多次点击。
 *       由于操作都是按时间顺序的，下一次的时间戳都会大于等于本次的时间戳. 需要两个array来存。
 *       O(s) s is total seconds in given time interval, in this case 300.
 * basic ideal is using buckets. 1 bucket for every second because we only need to keep the recent hits info for
 * 300 seconds. hit[] array is wrapped around by mod operation. Each hit bucket is associated with times[] bucket
 * which record current time. If it is not current time, it means it is 300s or 600s... ago and need to reset to 1.
 */

public class DesignHitCounter {
    private int[] times;
    private int[] hit;

    public DesignHitCounter() {
        times = new int[300];
        hit = new int[300];
    }

    public void hit(int timeStamp) {
        int index = timeStamp % 300;
        if (times[index] != timeStamp) {
            times[index] = timeStamp;
            hit[index] = 1;
        } else {
            hit[index]++;
        }
    }

    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hit[i];
            }
        }
        return total;
    }


}
