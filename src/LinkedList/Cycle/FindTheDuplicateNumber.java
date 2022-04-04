package LinkedList.Cycle;

/**
 *
 *
 * https://www.youtube.com/watch?v=SmfDjRGS_V4&t=313s
 */

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

}
