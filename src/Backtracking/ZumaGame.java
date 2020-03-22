package Backtracking;

/**
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.
 * <p>
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place).
 * Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.
 * <p>
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: board = "WRRBBW", hand = "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 * Example 2:
 * <p>
 * Input: board = "WWRRBBWW", hand = "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 * Example 3:
 * <p>
 * Input: board = "G", hand = "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty
 * Example 4:
 * <p>
 * Input: board = "RBYYBBRRB", hand = "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 * <p>
 * <p>
 * Constraints:
 * <p>
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * The number of balls on the table won't exceed 16, and the string represents these balls is called "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 */


public class ZumaGame {

    final static int MAX_COUNT = 6;

    public static int findMinStep(String board, String hand) {
        int[] count = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            count[hand.charAt(i) - 'A']++;
        }
        int res = helper(board + "#", count); // 当 A B W， hand是 WW 的时候，可以让fast - slow的出有一个W，而不是0个。 这种
        int secondRes = 0;
        if (res == MAX_COUNT) {
            secondRes = helper(new StringBuilder(board).reverse().toString() + "#", count);
        }

        return res == MAX_COUNT && secondRes == 0 ? -1 : Math.min(res, secondRes);
    }

    private static int helper(String s, int[] count) {
        // remove 新的inputString的可以移除的char，跟下面 helper(s.substring(0, slow) + s.substring(fast), count)
        // 的"remove"相辅相成
        s = remove(s);
        if (s.equals("#")) {
            return 0;
        }

        int res = MAX_COUNT;
        for (int slow = 0, fast = 0; fast < s.length(); fast++) {
            if (s.charAt(fast) == s.charAt(slow)) {
                continue;
            }
            int need = 3 - (fast - slow); // 需要的个数，比如 WBW， 这样第一次W就需要两个
            if (count[s.charAt(slow) - 'A'] >= need) { // 有足够的插进去
                count[s.charAt(slow) - 'A'] -= need;

                // 比如 board = BWBB, hand = WW -> 这一个把WW加入到W后的WWW消除是由这个recursive完成， 至于recursive后BBB这个新的string就由recursive里面的remove去解除
                res = Math.min(res, need + helper(s.substring(0, slow) + s.substring(fast), count));
                count[s.charAt(slow) - 'A'] += need;
            }
            slow = fast;
        }
        return res;
    }

    private static String remove(String board) {

        int slow = 0;
        int fast = 0;
        while (fast < board.length()) {
            if (board.charAt(fast) == board.charAt(slow)) {
                fast++;
                continue;
            }
            if (fast - slow >= 3) {
                return remove(board.substring(0, slow) + board.substring(fast));
            } else {
                slow = fast;
            }
            fast++;
        }
        return board;
    }
}
