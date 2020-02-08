package Array;


/**
 * Example Input :         1, 3, 4, 2, 5,  7,  2, 3
 * ----------------------------------------
 * rob:                    1, 3, 5, 5, 10, 12, 12, 15
 * not rob:                0, 1, 3, 5, 5,  10, 12, 12
 */

public class HouseRobber {

    public int rob(int[] num) {

        int rob = 0;    //max monney can get if rob current house
        int notRob = 0; //max money can get if not rob current house

        for (int i = 0; i < num.length; i++) {
            int currRob = notRob + num[i]; //if rob current value, previous house must not be robbed
            notRob = Math.max(notRob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currRob;

        }
        return Math.max(rob, notRob);
    }
}
