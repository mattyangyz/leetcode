package DP;

public class ClimbingStairs {

    public int climb(int stairs) {
        return climbStairs(0, stairs);
    }

    private int climbStairs(int curr, int stairs) {
        if (curr > stairs) {
            return 0;
        }
        if (curr == stairs) {
            return 1;
        }
        return climbStairs(curr + 1, stairs) + climbStairs(curr + 2, stairs);
    }
}
