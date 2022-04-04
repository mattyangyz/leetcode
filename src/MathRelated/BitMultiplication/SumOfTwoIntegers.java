package MathRelated.BitMultiplication;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 * <p>
 * Input: a = -2, b = 3
 * Output: 1
 * <p>
 * 思路:
 * <p>
 * There's lot of answers here, but none of them shows how they arrived at the answer, here's my simple try to explain.
 * <p>
 * Eg: Let's try this with our hand 3 + 2 = 5 , the carry will be with in the brackets i.e "()"
 * <p>
 * 3 => 011
 * 2=>  010
 * ____
 * 1(1)01
 * Here we will forward the carry at the second bit to get the result.
 * So which bitwise operator can do this ? A simple observation says that XOR can do that,but it just falls short in dealing with the carry properly, but correctly adds when there is no need to deal with carry.
 * For Eg:
 * <p>
 * 1   =>  001
 * 2   =>  010
 * 1^2 =>  011 (2+1 = 3)
 * So now when we have carry, to deal with, we can see the result as :
 * <p>
 * 3  => 011
 * 2  => 010
 * 3^2=> 001
 * Here we can see XOR just fell short with the carry generated at the second bit.
 * So how can we find the carry ? The carry is generated when both the bits are set, i.e (1,1) will generate carry but (0,1 or 1,0 or 0,0) won't generate a carry, so which bitwise operator can do that ? AND gate ofcourse.
 * <p>
 * To find the carry we can do
 * <p>
 * 3    =>  011
 * 2    =>  010
 * 3&2  =>  010
 * now we need to add it to the previous value we generated i.e ( 3 ^ 2), but the carry should be added to the left bit of the one which genereated it.
 * so we left shift it by one so that it gets added at the right spot.
 * <p>
 * Hence (3&2)<<1 => 100
 * so we can now do
 * <p>
 * 3 ^2        =>  001
 * (3&2)<<1    =>  100
 * <p>
 * Now xor them, which will give 101(5) , we can continue this until the carry becomes zero.
 */

public class SumOfTwoIntegers {

    public static void main(String[] strs){
        System.out.println((3 & 3) + "-----------");
    }

    public int getSum(int a, int b) {

        int c = 0;

        while (b != 0) {
            c = a & b;          // 先计算carry
            a = a ^ b;          // 再计算结果
            b = c << 1;         // shift 一次再加carry
        }
        return a;
    }
}
