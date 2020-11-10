package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 频率 不算多
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * <p>
 * 思路: O(3^4) -> O(1), 对于每个index，取一个 两个 三个这样走， 必须是count等于4和index等于最后一位的时候才能加入到结果里面去。
 * <p>
 * 这道题也是一个用DFS找所有的可能性的问题。这样一串数字：25525511135
 * 我们可以对他进行切分，但是根据IP的性质，有些切分就是明显不可能的：
 * 比如011.11.11.11, 这个的问题是以0开头了，不合法，直接跳过。
 * 比如257.11.11.11, 257大于IP里的最大数 255了，不合法，直接跳过。
 * 然后我们把这一层切分后剩下的字符串传到下一层，继续去找。
 * 直到最后我们得到4个section为止，把这个结果存到我们的result list。
 *
 * 整个流程就是backtracking。
 * 1. 对于 22315912345， 先变成 2.2.3.1 虽然count = 4， 但是index != s.length() 所以不满足，退回到 1 那一层，变成 2.2.3.15 还是不满足，
 * 然后慢慢expand，然后退，expand 退。 直到满足位置。
 */

public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses.restoreIpAddresses("22315912345");
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, "", 0);
        return res;
    }

    public static void helper(List<String> res, String s, int index, String ret, int count) {
        if (count > 4) {
            return;
        }
        if (count == 4 && index == s.length()) {            // 有四个部分，而且整个string都用完了
            res.add(ret.substring(0, ret.length() + 1));
            return;
        }
        for (int i = 1; i < 4; i++) {                       //取三个数， 从一到三
            if (index + i > s.length()) {
                break;
            }
            String temp = s.substring(index, index + i);   // 取一个数，取两个数， 取三个数

            // 如果从0开始而且长度大于一 跳过， 这里判断越界
            // (temp.startsWith("0") && temp.length() > 1) 是防止出现 01 这种情况，但是 只是单独 0 是合法的
            if ((temp.startsWith("0") && temp.length() > 1) || Integer.parseInt(temp) > 255) {
                continue;
            }
            //i 是每1个，每两个，每三个这样取。
            helper(res, s, index + i, ret + temp, count + 1);
        }
    }
}
