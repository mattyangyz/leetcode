package Array;

// based on the fact that, if total gas is greater or equal to total cost,
// then there must be a sulution.


/**
 * here are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 */

public class GasStation {
    public static int canComplete(int[] gas, int[] cost) {
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }
        if (tank < 0) {
            return -1;
        }

        int accu = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            accu += gas[i] - cost[i];
            if (accu < 0) {
                start = i + 1;
                accu = 0;
            }
        }
        return start;
    }
}
