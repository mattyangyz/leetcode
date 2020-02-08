package StringRelated.ReverseString;

/**
 * Given an input string , reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 * Note:
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces.
 * The words are always separated by a single space.
 * Follow up: Could you do it in-place without allocating extra space?
 * <p>
 * <p>
 * 思路: 先把整体给reverse了，然后根据 ' ' 再去reverse剩下的。大范围地reverse 然后小范围再word里面reverse。
 */

public class ReverseWordsInAStringII {

    public void reverseWords(char[] chars) {

        reverse(chars, 0, chars.length - 1);  //  先把整体给reverse了，the sky -> yks eht
        int r = 0;

        while (r < chars.length) {
            int l = r;

            while (r < chars.length && chars[r] != ' ') {
                r++;
            }

            reverse(chars, l, r - 1);            // 单词小范围地reverse。
            r++;                                    // 这是space后面单词的起始位置
        }

    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}
