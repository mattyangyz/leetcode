package TwoPointers;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * <p>
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 * <p>
 * 题意:  把所有的k次重复去掉，直到不能再去除为止。
 * <p>
 * 思路: 用two pointers，第一个pointer是current的遍历指针 第二个pointer是在result里面的insertion index。
 * 还需要用一个count来记录当前有多少个相同的元素。count array是一个关键.
 */


public class RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {
        int indexToSetInResult = 0;
        char[] res = s.toCharArray();
        int[] count = new int[s.length()];
        for (int j = 0; j < s.length(); indexToSetInResult++, j++) {
            res[indexToSetInResult] = res[j];
            // 当前的count个数取决于当前在j的char是否跟之前的char一样，如果一样的话 当前count的个数就去之前的char的+1。这里是关键。
            count[indexToSetInResult] = (indexToSetInResult > 0 && res[indexToSetInResult - 1] == res[j]) ?
                    count[indexToSetInResult - 1] + 1 : 1;

            if (count[indexToSetInResult] == k) {
                indexToSetInResult -= k;
            }
        }
        return new String(res, 0, indexToSetInResult);
    }
}
