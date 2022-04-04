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
 * 思路: 利用第一个word作为prefix先, 然后不断indexof去看这个prefix有没有出现 缩小结果就行。
 */

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String common = strs[0];

        for(String str: strs){
            int index = common.length();
            while(str.indexOf(common.substring(0, index)) != 0) {
                index--;
            }

            common = common.substring(0, index);
        }

        return common;
    }
}
