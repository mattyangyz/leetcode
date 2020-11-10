package StringRelated;


/**
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * <p>
 * <p>
 * Note:
 * <p>
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * <p>
 * <p>
 * 思路: 没什么fancy的algo， 就是一道实现题。 两个while，一个外面的string，一个里面的repeat的个数。巧妙的地方在于怎么把双位数
 * 的count，变成char array。也算是两个pointer，一个往前走，一个保存insert的index。
 */

// 外面的while走整个char array，里面的while走有多少重复的。巧妙地利用两类index，第一类是正常的走index，第二类是resInsertIndex
// 用来存放结果的index，注意怎么把两个数字变为char todo 那里有写
public class StringCompression {

    public int compress(char[] chars) {

        int resInsertIndex = 0;                                                // 用来作为res的count去计算index的
        int index = 0;

        while (index < chars.length) {
            char cur = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == cur) {   // 数一下一共有多少个
                index++;
                count++;
            }
            chars[resInsertIndex++] = cur;
            if (count != 1) {
                for (char c : String.valueOf(count).toCharArray()) {// todo: 巧妙的地方：把count转换成char array的形式
                    chars[resInsertIndex++] = c;
                }
            }
        }
        return resInsertIndex;                                                 // 最后这里的res会被加多一个 因为line 18，所以这就是正确的个数
    }
}
