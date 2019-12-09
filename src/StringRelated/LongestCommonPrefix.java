package StringRelated;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * 思路: 利用第一个word 然后不断indexof去 缩小结果就行。两个while loop
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prev = strs[0];
        int runningIndex = 1;

        while (runningIndex < strs.length) {

            while (strs[runningIndex].indexOf(prev) != 0) {
                prev = prev.substring(0, prev.length() - 1);
            }
            runningIndex++;
        }
        return prev;
    }
}
