package Hard;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */

// index 是 起始位置， runningPointer是不断向右边走得 看到 第几个words的index放不下（就是total char > maxWidth）
// gaps 是 有多少个地方有空格
// https://www.youtube.com/watch?v=qrZLQmL6fyI
public class TextJustification {

    public List<String> fullyJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int length = words.length;
        int index = 0;

        while (index < length) {

            int totalChar = words[index].length();
            int runningPointer = index + 1;

            while (runningPointer < length) {                                   // 这个while知道能加几个单词了
                // 当前的加上
                if (totalChar + words[runningPointer].length() + 1 > maxWidth) {
                    break;
                }
                totalChar += 1 + words[runningPointer].length();
                runningPointer++;

            }

            int gaps = runningPointer - index - 1;      // 为什么减一呢，因为这时候last其实已经是不满足条件的单词了
            StringBuilder sb = new StringBuilder();

            if (runningPointer == length || gaps == 0) {  // 题目要求 For the last line of text, it should be left justified and no extra space is inserted between words.
                for (int i = index; i < runningPointer; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                }

                sb.deleteCharAt(sb.length() - 1);       // 减掉最后一个space以防超标，
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {                                           // 在中间
                int spaces = (maxWidth - totalChar) / gaps;
                int rest = maxWidth - totalChar % gaps;     // 如果 rest 是三的话，就三个space平均分给 index index + 1 index + 2的gap中

                for (int i = index; i < runningPointer - 1; i++) {
                    sb.append(words[i]);
                    sb.append(' ');
                    // i - index 是计算offset，
                    for (int j = 0; j < spaces + (i - index < rest ? 1 : 0); j++) {   // append 多余的 spaces的
                        sb.append(' ');
                    }
                }

                sb.append(words[runningPointer - 1]);
            }
            res.add(sb.toString());
            index = runningPointer;
        }

        return res;
    }

}
