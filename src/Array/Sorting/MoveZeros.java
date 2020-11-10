package Array.Sorting;

/**
 *
* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
* Example:
* Input: [0,1,0,3,12]
* Output: [1,3,12,0,0]
 *
 * 类似于双指针的做法， 先把数字往前面放， 然后后面的全部填充为0就行。
*/
public class MoveZeros {

    public void moveZeros(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
