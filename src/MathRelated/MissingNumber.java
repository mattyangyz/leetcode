package MathRelated;

//就用高斯法就好了
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return ((1 + nums.length)) * nums.length / 2 - sum;
    }
}
