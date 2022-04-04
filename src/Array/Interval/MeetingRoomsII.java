package Array.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 * 思路: 两边走，start time和end time都排序然后分别走
 *
 * 高频
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 * <p>
 * <p>
 * Time --------------------------------------->
 * <p>
 * Start    1   2       3       4
 *          |   |       |       |
 * <p>
 * End              a       b       c
 *                  |       |       |
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 当start在1的时候， end在a，这时候表明需要alloc一个房间。
 * 当start在2的时候， end在a，这时候表明需要安排第二个房间。
 * 当start在3的时候， 表明已经有一个房间在a那里结束了，可以用那个房间，
 * 当start在4， end在b的时候 表明已经有房间结束 可以用那个房间。
 */

public class MeetingRoomsII {

    public static int minMeetingRoomsWithHeap(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue(); // 默认是一个min heap

        minHeap.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minHeap.peek()) {          // 表明当前的intervals i可以利用之前的在最top上的interval，所以把之前的给poll掉
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }

        return minHeap.size();
    }


    public int minMeetingRooms(int[][] intervals) {

        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];


        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
        }

        for (int i = 0; i < intervals.length; i++) {
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int start = 0;
        int end = 0;
        int room = 0;
        while(start < intervals.length){
            if(startTime[start] < endTime[end]){
                room++;
            }
            else{
                end++;
            }
            start++;
        }
        return room;
    }
}
