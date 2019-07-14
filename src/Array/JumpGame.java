package Array;


/**
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0,
 * which makes it impossible to reach the last index.
 *
 * The easiest way to think about this problem is to ask are the elements with a 0 value avoidable?
 * this is the algorithm that I constructed to answer this question.
 * Starting from the second to last element in the array we continue to decrement towards the start of the array.
 * Only stopping if we hit an element with a value of 0;
 * in this case we evaluate if there exist an element somewhere at the start of the array which has a
 * jump value large enough to jump over this 0 value element.
 *
 * [3,2,1,0,4] not reachable
 * [3,2,2,0,4] reachable
 *
 *
 *
 */

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length < 2) {
            return true;
        }

        for (int curr = nums.length - 2; curr >= 0; curr--) {
            if (nums[curr] == 0) {
                int neededJumps = 1;
                while (neededJumps > nums[curr]) {
                    neededJumps++;
                    curr--;

                }
            }
        }
        return true;
    }
}
