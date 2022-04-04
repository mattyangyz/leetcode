package MathRelated.BitMultiplication;

public class PowerOfTwo {

    // 2^0 = 01
    // 2^1 = 10
    // 2^2 = 100
    // 2^3 = 1000
    public static boolean isPowerOfTwo(int n){
        return n == 0 && ((n & (n - 1)) == 0);
    }
}
