package BinarySearch_IMPORTANT.RegularTempldateLessThanEqualsTo_IMPORTANT;


// 解题的思路在这里 -> https://leetcode.com/problems/koko-eating-bananas/discuss/1703687/JavaC%2B%2B-A-very-very-well-detailed-explanation
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int rightRange = Integer.MIN_VALUE;
        for(int num: piles){
            if(num > rightRange){
                rightRange = num;
            }
        }
        int minHours = Integer.MAX_VALUE;

        int left = 1;                       // 这里一定不能从0，开始，不然会有 / 0的风险！！
        int right = rightRange;
        while(left <= right){

            int speed = left + (right - left) / 2;
            int needHours = countHours(piles, speed);

            if(needHours > h){
                left = speed + 1;
            }
            else if (needHours <= h){
                right = speed - 1;
                minHours = speed;
            }
        }
        return minHours;
    }

    private int countHours(int[] piles, int speed){
        int count = 0;
        for(int num: piles){
            count += num / speed;
            if(num % speed != 0){
                count += 1;
            }
        }
        return count;
    }
}
