package BinarySearch_IMPORTANT;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * 意思: 看例子 1 1 2 3 3 4 4 5 5 6 6 7 7
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 -> 如果是invalid的话 偶数是第二个，基数是其他不一样的
 * <p>
 * 1 1 2 2 3 3 4 4 5 5 6 6 7
 * *        0 1 2 3 4 5 6 7 8 9 10 11 12 -> 如果是valid的话 偶数是第一个，基数是第二个
 * <p>
 * target number 只会出现在偶数的index上面，但是计算出来的mid会包含基数偶数，所以要判断
 * 是基数还是偶数 然后进行相应的increment。
 */

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(mid % 2 == 0){
                if(nums[mid] == nums[mid + 1]){             // 其实可以理解为因为这里要看 mid + 1， 所以不能 left <= right，如果遇到11223这样的就会overbound！
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
            else{
                if(nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                }
                else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
