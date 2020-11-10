package Design;

import java.util.HashSet;
import java.util.Set;

/**
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 * <p>
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * It is possible that several messages arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * Logger logger = new Logger();
 * <p>
 * // logging string "foo" at timestamp 1
 * logger.shouldPrintMessage(1, "foo"); returns true;
 * <p>
 * // logging string "bar" at timestamp 2
 * logger.shouldPrintMessage(2,"bar"); returns true;
 * <p>
 * // logging string "foo" at timestamp 3
 * logger.shouldPrintMessage(3,"foo"); returns false;
 * <p>
 * // logging string "bar" at timestamp 8
 * logger.shouldPrintMessage(8,"bar"); returns false;
 * <p>
 * // logging string "foo" at timestamp 10
 * logger.shouldPrintMessage(10,"foo"); returns false;
 * <p>
 * // logging string "foo" at timestamp 11
 * logger.shouldPrintMessage(11,"foo"); returns true;
 * <p>
 * 意思: 如果string放入前后时间大于十秒，然后print true。如果前后时间小于十秒的
 * 就return false。
 */

public class LoggerRateTimer {

    private int[] buckets;
    private Set[] sets;

    public LoggerRateTimer() {
        buckets = new int[10];
        sets = new Set[10];

        for (int i = 0; i < sets.length; i++) {
            sets[i] = new HashSet();
        }
    }

    public boolean shouldPrintMessage(int timeStamp, String message) {
        int index = timeStamp % 10;

        // 表明已经超出 10s 这个window，所以可以直接清除掉
        if (timeStamp != buckets[index]) {    // 3 foo, 3 shot, 13 foo， 这时候 13 != 3 会把 foo跟shot都remvoe 但没关系的。 shot在下一次call的时候会print true的
            sets[index].clear();
            buckets[index] = timeStamp;
        }

        for (int i = 0; i < buckets.length; i++) { //3 foo， 然后 8 foo这种情况会return false
            if (timeStamp - buckets[i] < 10) {
                if (sets[i].contains(message)) {
                    return false;
                }
            }
        }

        sets[index].add(message); // 只有大于10s的时候才加进来
        return true;
    }
}
