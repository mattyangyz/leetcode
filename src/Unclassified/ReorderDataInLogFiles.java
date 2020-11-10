package Unclassified;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * <p>
 * 意思: 先看第一个单词是什么然后排序，按照原来排序的话 只需要return 0就行了
 */

// 重写Comparator里面的compare method，记得用indexOf得到第一个 ' '， 然后判断这个 ' ' 后面的字符。
public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int s1SpaceIndex = o1.indexOf(' ');
                int s2SpaceIndex = o2.indexOf(' ');

                char s1FirstCharacter = o1.charAt(s1SpaceIndex + 1);
                char s2FirstCharacter = o2.charAt(s2SpaceIndex + 1);

                if (s1FirstCharacter <= '9') {        // 第一个是数字
                    if (s2FirstCharacter <= '9') {    // 第二个也是
                        return 0;
                    } else {
                        return 1;
                    }
                }
                if (s2FirstCharacter <= '9') {        // 第一个letter， 第二个是数字的
                    return -1;
                }

                int preCompute = o1.substring(s1SpaceIndex + 1).compareTo(o2.substring(s2SpaceIndex + 1));
                if (preCompute == 0) {  // 后面的letter都一样，然后对比identifier, 这个一开始不需要加 要问了需求之后再加
                    return o1.substring(0, s1SpaceIndex).compareTo(o2.substring(0, s2SpaceIndex));
                }
                return preCompute;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }
}
