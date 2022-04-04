package PriorityQueue__IMPORTANT;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.
 * <p>
 * If there is no common time slot that satisfies the requirements, return an empty array.
 * <p>
 * The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
 * <p>
 * It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * Output: [60,68]
 * Example 2:
 * <p>
 * Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * Output: []
 * <p>
 * 意思: 不需要额外的data structure。只需要一个就够了，因为同一个人里面的slots不会有overlap。
 * 即使取出来的是一个人的两个slots，也没关系，因为上述的fact 所以这两个slots不会构成一个result。
 * 同时用prev的意思是每次都把小的那个start给去掉，保留较大的那个歌进行下一次的iterate.
 * <p>
 * 2020-JUN-09
 */

// 注意这题是available time而不是busy time，这题注意判断怎么决定当前的跟之前的能构成一个duration， 这是关键。
// 然后想明白为什么可以直接prev = current。 注意，不会出现  --------
//                                                       ---    上面的end比下面的end要大，但是curr[0]+ duration比curr[1]小的这种情况， 不会出现， 因为加进去的时候slot[1] - slot[0]再加的，
// 所以可以放心的直接prev = current，保留大(start)的那个到下一次iterate里面。
public class MeetingScheduler {

    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                priorityQueue.add(slot);
            }
        }

        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                priorityQueue.add(slot);
            }
        }


        int[] prev = new int[2];
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            if (prev != null && current[0] + duration <= prev[1]) {
                return Arrays.asList(current[0], current[0] + duration);
            }
            prev = current;                 // 如果curr[0] + duration  > prev[1]的话，才执行这里的。不然的话，早就在current[0] + duration <= prev[1]就return出去了。
            // 所以可以直接地prev = current 如果上面那个 if 不满足的话。
        }
        return Arrays.asList();
    }
}
