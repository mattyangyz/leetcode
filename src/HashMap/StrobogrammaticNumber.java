package HashMap;


import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input:  "69"
 * Output: true
 * Example 2:
 * <p>
 * Input:  "88"
 * Output: true
 * Example 3:
 * <p>
 * Input:  "962"
 * Output: false
 */

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');

        if (num.length() % 2 != 0) {
            return false;
        }

        int left = 0;
        int right = num.length() - 1;

        while (left <= right) {                       // 这里必须是 <= 防止单个字母出现的情况
            if (!map.containsKey(num.charAt(left))) {
                return false;
            }

            if (map.get(num.charAt(left)) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
