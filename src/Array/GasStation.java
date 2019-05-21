package Array;

// based on the fact that, if total gas is greater or equal to total cost,
// then there must be a sulution.
public class GasStation {
    public static int canComplete(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }

        int start = 0;
        int accmulate = 0;
        for (int i = 0; i < gas.length; i++) {
            int curGain = gas[i] - cost[i];
            if (accmulate + curGain < 0) {
                start = i + 1;
                accmulate = 0;
            }
            else{
                accmulate += curGain;
            }
        }
        return start;
    }
}
