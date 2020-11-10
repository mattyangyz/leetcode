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

// 不断地往左边累加这样的一个过程，但要注意三个三个那样处理，这样才能表现出Thousand， million， billion。 while n > 0 是为了处理
// 1000 这种情况就直接skip到下一个那里去，如果是 1000 000，就会被skip两次直接变成 1 million。
public class IntegerToEnglishWords {

    public static void main(String[] args) {

        IntegerToEnglishWords.numberToWords(123);
    }

    private static final String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static String numberToWords(int n) {
        if (n == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while (n > 0) {
            // 先把数字以3个为一组分成若干小组
            if (n % 1000 != 0) {    // 5123 这个数字就需要对123做处理， 每三个每三个地去处理
                result = helper(n % 1000) + THOUSANDS[i] + " " + result;    // 345的话就取index 0， 要是1345的话就取index 1的 i。
            }
            i++;
            n /= 1000;
        }
        return result.trim(); // 去掉多余的space
    }

    private static String helper(int n) {
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
