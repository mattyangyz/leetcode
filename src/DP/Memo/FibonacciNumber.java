package DP.Memo;

public class FibonacciNumber {

    public int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        while (n > 1) {
            int sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return b;
    }


    public int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public int fibDynamicProgramming(int n) {

        if (n <= 1) {
            return n;
        }
        int[] fibCache = new int[n + 1];
        fibCache[1] = 1;

        for (int i = 2; i <= n; n++) {
            fibCache[i] = fibCache[i - 1] + fibCache[i - 2];
        }
        return fibCache[n];
    }
}
