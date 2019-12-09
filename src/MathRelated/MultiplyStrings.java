package MathRelated;


/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 思路: index 1         1   2   3
 * index 2             4   5
 * <p>
 * 1   5
 * 1   0
 * 0  5
 * 1   2               -> index[i + j, i + j + 1]
 * 0  8
 * 0  4
 * index     0  1   2  3   4
 */

public class MultiplyStrings {

    public String multiply(String nums1, String nums2) {
        if (nums1 == null || nums2 == null) {
            return "0";
        }
        int[] digits = new int[nums1.length() + nums2.length()];

        for (int i = nums1.length() - 1; i >= 0; i--) {
            for (int j = nums2.length() - 1; j >= 0; j--) {
                int product = (nums1.charAt(i) - '0') * (nums2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + digits[p2];

                digits[p1] += sum / 10;                     //进位
                digits[p2] = sum % 10;                      //取得个位数
            }
        }


        StringBuilder res = new StringBuilder();
        for (int digit : digits) {
            if (!(digit == 0 && res.length() == 0)) {       //最前面的0 不要
                res.append(digit);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
