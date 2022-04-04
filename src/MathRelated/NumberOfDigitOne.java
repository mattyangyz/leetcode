package MathRelated;


// todo: not yet!!!!
public class NumberOfDigitOne {

    public static void main(String[] args) {
        countDigitOne(502);
    }

    public static int countDigitOne(int number) {
        int res = 0;
        for(long m = 1; m <= number; m *= 10){
            long a = number / m;
            long b = number % m;
            res += (a + 8) / 10 * m;
            if (a % 10 == 1) {
                res += b + 1;
            }
        }
        return res;
    }
}
