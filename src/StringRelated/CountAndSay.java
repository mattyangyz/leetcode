package StringRelated;


/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 */


// 暴力解法， 从n = 1开始构建，每次n构建完了就是一个新的say，下一个n构建的时候是基于这个新的say的。
// https://www.youtube.com/watch?v=0EGzSHEbXrQ
public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay.countAndSay2(6);
    }


    public static String countAndSay2(int n) {

        String say = "1";                       // base case = 1

        for (int i = 1; i < n; i++) {             // 走 n 的长度

            StringBuilder sb = new StringBuilder(); // 这其实是构建一个新的say
            char start = say.charAt(0);
            int count = 0;

            for (int j = 0; j < say.length(); j++) {     // 走say的长度
                char curr = say.charAt(j);
                if (curr == start) {
                    count += 1;
                } else {
                    sb.append(count).append(start);
                    count = 1;                          // 因为下一次j已经j++了 所以count得 = 1， 不是0
                    start = say.charAt(j);
                }
            }

            sb.append(count).append(start);         // 因为最后走到最尾的话 其实最后几个是还没有赋值的
            say = sb.toString();
        }

        return say;
    }


    public static String countAndSay(int n) {

        String say = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char start = say.charAt(0);
            int count = 0;

            for (int j = 0; j < say.length(); j++) {
                char c = say.charAt(j);
                if (c == start) {
                    count++;
                } else {
                    sb.append(count).append(start);
                    count = 1;
                    start = say.charAt(j);
                }
            }

            sb.append(count).append(start);
            say = sb.toString();
        }
        return say;
    }
}
