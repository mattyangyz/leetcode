package Array.MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 *  思路:   第一种是排序。 直接排序 然后num[nums.length / 2】就是那一个元素。
 *           第二种是利用hashmap， 一边往里面添加一边检查有没有大于nums.length / 2的元素。
 *             第三种是moore voting algo. 理解 -> https://leetcode.com/problems/majority-element-ii/discuss/63537/My-understanding-of-Boyer-Moore-Majority-Vote
 *
 */


public class MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {           // 一边加到hashmap里面一边检查有没有大于nums.length/2， 如果有就马上返回break
        Map<Integer, Integer> map = new HashMap<>();

        int ret = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else{
                map.put(num, map.get(num) + 1);
            }
            if (map.get(num) > nums.length / 2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    // 每次都找出一对不同的元素， 从数组中删除。 知道数组为空或只有一种元素
    // 不难证明， 如果存在元素e出现的频率拆过半数，那么数组中最后剩下的就只有e。
    public int majorityElement3(int[] nums) {           // 这个做法巧妙，必须理解
        int count = 0;
        int ans = 0;
        for (int num : nums) {
            if (count == 0) {
                ans = num;
            }
            if (num != ans) {
                count--;
            } else {
                count++;
            }
        }
        return ans;
    }
}
