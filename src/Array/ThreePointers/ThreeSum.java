package Array.ThreePointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO: TRICKY
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 *
 *
 * 主要思想是，遍历数组，用 0 减去当前的数，作为 sum ，然后再找两个数使得和为 sum。
 *
 * 这样看来遍历需要 O（n），再找两个数需要 O（n²）的复杂度，还是需要 O（n³）。
 *
 * 巧妙之处在于怎么找另外两个数。
 *
 * 最最优美的地方就是，首先将给定的 num 排序。
 *
 * 这样我们就可以用两个指针，一个指向头，一个指向尾，去找这两个数字，这样的话，找另外两个数时间复杂度就会从 O（n²），降到 O（n）。
 *
 * 而怎么保证不加入重复的 list 呢？
 *
 * 要记得我们的 nums 已经有序了，所以只需要找到一组之后，<关键>1. 当前指针要移到和当前元素不同的地方。2. 其次在遍历数组的时候，如果和上个数字相同，也要继续后移<关键>。文字表述比较困难，可以先看下代码。
 *
 * <关键>1, 必须要记得是在加完第一个结果的时候就得判断。
 *
 * 这种写法，可以避免结果集中有重复，因为数组时排好序的，所以当一个数被放到结果集中的时候，其后面和它相等的直接被跳过。
 *
 */

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){

            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];

            if(i != 0 && nums[i] == nums[i - 1]){                   // 跳过重复的
                continue;
            }

            while(left < right){
                int tempSum = nums[left] + nums[right];
                if(tempSum == target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    list.add(res);
                    while(left < right && nums[left] == nums[left + 1]){            // 跳过重复的
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){          // 跳过重复的
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(tempSum < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return list;
    }
}
