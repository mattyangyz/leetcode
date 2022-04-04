package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;


/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */

//思路: 两个loop，第一个是到第几个数字，里面的j loop的到当前这个数字里面的所有subarray。
//譬如 i = 3的时候，j会走 0 1 2，然后 3 跟 0, 1, 2比看当前这个 i 的数字能否跟之前的结果构成一个increasing subsequence
//注意比较得用一个local max var len， 不能直接用一个global max。
// https://www.youtube.com/watch?v=l2rCz7skAlk
// 这个也很有用 -> https://www.youtube.com/watch?v=5rfZ4WnNKBk&t=1s
public class LongestIncreasingSubsequence_IMPORTANT_IMPORTANT {

    public static void main(String[] args) {
        LongestIncreasingSubsequence_IMPORTANT_IMPORTANT.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9});
    }

    public static int lengthOfLIS(int[] num) {

        if (num.length == 0) {
            return 0;
        }

        int[] res = new int[num.length];
        int globalMax = 1;

        for (int i = 0; i < num.length; i++) {

            int len = 1;                        //最短是1
            for (int j = 0; j < i; j++) {         //遍历之前的结果， 这里 j < i 或者 j <= i都是可以的， 如果 j <= i，则49行可以放进去j的那个for loop里面！


                if (num[j] < num[i]) {
                    len = Math.max(len, res[j] + 1);
                }
            }
            res[i] = len;
            globalMax = Math.max(globalMax, len);
        }

        return globalMax;
    }


    public static int lengthOfLISBS(int[] nums) {   // 这个解法是根据这一个来的 -> https://www.youtube.com/watch?v=KEekXzxll9k&t=465s
        int n = nums.length;
        int[] tails = new int[n];
        int tailsLength = 0;

        for(int num: nums){

            int left = 0;
            int right = tailsLength - 1;

            while(left <= right){

                int mid = left + (right - left) / 2;

                if(tails[mid] < num){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            if(left == tailsLength){
                tails[tailsLength] = num;
                tailsLength++;
            }
            else{
                tails[left] = num;
            }
        }
        return tailsLength;
    }
}
