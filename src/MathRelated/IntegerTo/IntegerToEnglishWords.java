package MathRelated.IntegerTo;


/**
 * https://www.youtube.com/watch?v=PXAlSu77es0&list=PL9d8fhqjCAgoOV_W_Mo-4C6xQDcB7OovF&index=23
 * <p>
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords {
    private final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int n) {
        if (n == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                result = helper(n % 1000) + THOUSANDS[i] + " " + result;
            }
            i++;
            n /= 1000;
        }
        return result.trim(); // 去掉多余的space
    }

    private String helper(int n) {
        if (n == 0) {
            return "";
        } else if (n < 20) {// 1 - 19
            return LESS_THAN_TWENTY[n] + " ";
        } else if (n < 100) { // 20 - 99
            return TENS[n / 10] + " " + helper(n % 10);
        } else {
            return LESS_THAN_TWENTY[n / 100] + " Hundred " + helper(n % 100); //这里call helper是因为不知道十位跟个位是小于
        }
    }
}
