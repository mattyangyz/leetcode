package Greedy;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * <p>
 * <p>
 * 思路: https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation
 * 1) 数一下最高的frequency是多少
 * 2）计算一下需要多少part A??A??A 这里代表2parts
 * 3) 计算一下有多少empty slot
 * 4）如果 emptySlot < 0 代表 you have already got enough tasks to fill in each part to make arranged tasks valid.
 * But as I said you can always put more tasks in each part once you met the "minimum" requirement.
 */

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0;

        //To get count(A) and count of tasks with most frequency,
        // we need to go through inputs and calculate counts for each distinct char.

        for (char task : tasks) {
            counter[task - 'A']++;                  // max is the MAX occurance
            if (max == counter[task - 'A']) {        // maxCount is to check how many char having the same MAX number
                maxCount++;
            } else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max - 1;                    // 3A 2B 1C ->  A ?? A ?? A = 2 parts

        // partlength can be negative
        int partLength = n - (maxCount - 1);        // 3A 3B 1C then maxCount = 2 n = 2 -> AB?AB?AB

        // emptySlots can be negative
        int emptySlots = partCount * partLength;    // count how many empty slots are needed

        int availableTasks = tasks.length - max * maxCount; // count how many available tasks can fill the empty slots
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }
}
