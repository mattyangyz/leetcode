package Array;

public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsDP(int n) {
        int memo[] = new int[n + 1];
        return climbStairsDP(0, n, memo);
    }

    private int climbStairsDP(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairsDP(i + 1, n, memo) + climbStairsDP(i + 2, n, memo);
        return memo[i];
    }
}
