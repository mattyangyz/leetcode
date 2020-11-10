package Array;


/**
 *
 * 每次找局部最优，最后达到全局最优，完美！
 *
 * https://leetcode.wang/leetCode-45-Jump-Game-II.html
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 *
 *
 * Input: [2, 3,1 ,1, 3 ,4, 1]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * 从数组的第 0 个位置开始跳，跳的距离小于等于数组上对应的数。求出跳到最后个位置需要的最短步数。
 * 比如上图中的第 0 个位置是 2，那么可以跳 1 个距离，或者 2 个距离，我们选择跳 1 个距离，
 * 就跳到了第 1 个位置，也就是 3 上。然后我们可以跳 1，2，3 个距离，我们选择跳 3 个距离，就直接到最后了。所以总共需要 2 步。
 *
 * 需要注意为什么是nums.length - 1
 *
 * 这里要注意一个细节，就是 for 循环中，i < nums.length - 1，少了末尾。
 * 因为开始的时候边界是第 0 个位置，steps 已经加 1 了。
 * 如下图，如果最后一步刚好跳到了末尾，此时 steps 其实不用加 1 了。如果是 i < nums.length,
 * i 遍历到最后的时候，会进入 if 语句中，steps 会多加 1 。
 *
 *
 */

// 就在当前nums[i]最多能走到多少，然后当前的 index 于 index + nums[i] 形成一个区间。然后遍历这里面的区间，从 index i走到这个区间里面的
// 任何index都是步数为1的，走的同时要update windowCanReachMax, 当走到index + nums[i]的时候就再windowCanReachMax, 因为要走下一个区间了
// 下一个区间的长度是最新的 windowCanReachMax
public class JumpGameII {

    public int jump(int[] nums) {

        int requireSteps = 0;
        int windowCanReachMax = 0;
        int windowEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            windowCanReachMax = Math.max(windowCanReachMax, i + nums[i]);
            if (i == windowEnd) {
                requireSteps++;
                windowEnd = windowCanReachMax;
            }
        }
        return requireSteps;
    }
}
