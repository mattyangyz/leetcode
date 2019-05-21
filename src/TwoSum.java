import java.util.HashMap;
import java.util.Map;


/**
    Two ways of solving it. One is using one pass, one is using two pass.
 **/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target){

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


    public int[] twoSumTwoHashMaps(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{};
    }
}
