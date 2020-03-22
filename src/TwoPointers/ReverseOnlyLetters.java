package TwoPointers;


/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions.
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * <p>
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 * <p>
 * <p>
 * 思路: 就两个pointer即可，一个从左边 一个从右边。
 */


public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            while (i < j && !Character.isLetter(sb.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetter(sb.charAt(j))) {
                j++;
            }
            sb.setCharAt(i, s.charAt(j));
            sb.setCharAt(j, s.charAt(i));
        }
        return sb.toString();
    }
}
