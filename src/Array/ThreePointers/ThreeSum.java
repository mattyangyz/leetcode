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
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];

            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    ans.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) { // //元素相同要后移，防止加入重复的 list
                        low++;
                    }
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;                                              // watch out here
                    high--;
                }
                else if (nums[low] + nums[high] < sum) {
                    low++;
                }
                else{
                    high--;
                }
            }
        }
        return ans;
    }
}
