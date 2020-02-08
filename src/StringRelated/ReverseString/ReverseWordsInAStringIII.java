package StringRelated.ReverseString;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * <p>
 * 思路: 正常reverse。 碰到空格的话 就reverse前面的，不要忘记i = j + 1。 最后也要reverse。
 */

public class ReverseWordsInAStringIII {

    public String reverseWord(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (arr[j] == ' ') {
                reverse(arr, i, j - 1);
                i = j + 1;
            }
        }
        reverse(arr, i, arr.length - 1);
        return String.valueOf(arr);
    }

    public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

}
