package Unclassified;

import java.util.Arrays;
import java.util.Comparator;


/**
 * 不用看，没什么价值。 要理解为什么是s2.compareTo s1
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * 思路: 这里o1表示位于前面的字符，o2表示后面的字符
 *      上面的条件是，o1比o2小，这个时候，我们需要需要调整它们的顺序
 *      如果你想升序，那么o1比o2小就是我想要的；所以返回-1，类比成false；表示我不想调整顺序
 *      如果你想降序，那么o1比o2小不是我想要的；所以返回1，类比成true；表示我想调整顺序
 *
 */

// https://www.youtube.com/watch?v=LUxREjEADCw
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;                    // 两个数字合起来 哪个大
                String s2 = o2 + o1;
                return s2.compareTo(s1);                // 为什么是s2.compareTo s1
            }
        });

        if (res[0].charAt(0) == '0') {      // 如果一开始是0，后面的全部都会是0
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }
        return sb.toString();
    }
}
