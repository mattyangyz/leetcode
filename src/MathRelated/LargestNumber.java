package MathRelated;

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
 */

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
