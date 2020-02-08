package StringRelated.ReverseString;


/**
 * 有更好的solution
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * <p>
 * <p>
 * 思路: startIndex the current position available for insertion, j the end of one word, i the beginning of one word
 *       1. 放一个 " " 到前面如果不是第一个词的话 2. 把单词放到相应的结果position里面， starts with startIndex
 *       3. 翻转 4. 用i 找下一个start of word。
 *
 * 例如：
 *      "  hello    world!  "   先reverse成 "  !dlrow   olleh  " 然后 i 就走到 !这里， 然后j就等于i，然后执行完inner while的
 *      时候会变成 "!dlrowow  olleh  "， 这个时候startIndex指向第一个word里面的第二个o， 用startIndex - j -i 可以得到最开始的位置。
 *      下一次outer while的时候， 一个 space 就会被放到第一个o 那个位置(显示_那里)，变成 "world!_w  olleh  "。
 *
 *
 *
 */

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        if (s.length() < 1) {
            return s;
        }
        int startIndex = 0;          // the current position available for insertion
        char[] str = s.toCharArray();

        reverse(str, 0, str.length - 1); // reverse the whole string


        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                if (startIndex != 0) {
                    str[startIndex++] = ' ';
                }
                int j = i;
                while (j < str.length && str[j] != ' ') { // 把这一个单词放到res的 char array里面， 然后后面再进行reverse。
                    str[startIndex++] = str[j++];
                }
                reverse(str, startIndex - (j - i), startIndex - 1); // this startIndex - ( j - i ) is the start index of the current word in the result string
                i = j;

            }
        }
        return new String(str, 0, startIndex);

    }

    private static void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
