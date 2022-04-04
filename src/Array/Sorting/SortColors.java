package Array.Sorting;

/**
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * 思路: 我们先用两个指针，一个指向已经排好序的0的序列的后一个点，
 * 一个指向已经排好序的2的序列的前一个点。这样在一开始，
 * 两个指针是指向头和尾的，因为我们还没有开始排序。
 * 然后我们遍历数组，当遇到0时，将其和0序列后面一个数交换，然后将0序列的指针向后移。
 * 当遇到2时，将其和2序列前面一个数交换，然后将2序列的指针向前移。
 * 遇到1时，不做处理。
 * 这样，当我们遍历到2序列开头时，实际上我们已经排好序了，因为所有0都被交换到了前面，所有2都被交换到了后面。
 */

public class SortColors {

    public void sortColorsWithTwoPass(int[] nums) {

        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            }
            if (nums[i] == 1) {
                whiteCount++;
            }
            if (nums[i] == 2) {
                blueCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < redCount) {
                nums[i] = 0;
            } else if (i < redCount + whiteCount) {
                nums[i] = 1;
            }
            else{
                nums[i] = 2;
            }
        }
    }

    // 思路: https://www.youtube.com/watch?v=yTwW8WiGrKw
    // 思路就是定义三个空间，红色的insert空间，白色的可以不管，蓝色的放最后，只要红色，蓝色放好了，白色自然也会放好！！
    public static void sortColors(int[] nums) {
        int redInsert = 0;
        int unknownIndex = 0;
        int blueInsert = nums.length - 1;

        while(unknownIndex <= blueInsert){
            if(nums[unknownIndex] == 0){
                swap(nums, redInsert, unknownIndex);
                redInsert++;
                unknownIndex++;
            }
            else if(nums[unknownIndex] == 1){
                unknownIndex++;
            }
            else if(nums[unknownIndex] == 2){
                swap(nums, unknownIndex, blueInsert);
                blueInsert--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
