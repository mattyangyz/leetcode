package MathRelated.TwoSumFamily;

import java.util.HashMap;
import java.util.Map;


/** Linkedin Review 1
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 **/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) { // One pass
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public int[] twoSumTwoHashMaps(int[] nums, int target) { // Two pass, need to handle 3, 2, 4, target = 6 要去除自身
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) { // 要去除自身
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }
}
