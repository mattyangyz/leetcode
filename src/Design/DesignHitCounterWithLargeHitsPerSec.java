package Design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Linkedin
 * <p>
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * HitCounter counter = new HitCounter();
 * <p>
 * // hit at timestamp 1.
 * counter.hit(1);
 * <p>
 * // hit at timestamp 2.
 * counter.hit(2);
 * <p>
 * // hit at timestamp 3.
 * counter.hit(3);
 * <p>
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * <p>
 * // hit at timestamp 300.
 * counter.hit(300);
 * <p>
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * <p>
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 */

public class DesignHitCounterWithLargeHitsPerSec {

    Queue<Integer> hits = new LinkedList<>();
    Map<Integer, Integer> counts = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public DesignHitCounterWithLargeHitsPerSec() {
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int t) {
        if (counts.containsKey(t)) counts.put(t, counts.get(t) + 1);
        else {
            update(t);
            hits.add(t);
            counts.put(t, 1);
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        update(timestamp);
        int r = 0;
        for (int i : counts.values()) r += i;
        return r;
    }

    // Note that this is O(300) because we never have more than 300 items in the queue or counts.
    // In the worst case, we'd only need to remove 300 items.
    private void update(int timestamp) {
        while (!hits.isEmpty() && hits.peek() <= timestamp - 300) counts.remove(hits.poll());
    }
}
