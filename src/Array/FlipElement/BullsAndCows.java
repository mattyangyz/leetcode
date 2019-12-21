package Array.FlipElement;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask
 * your friend to guess what the number is. Each time your friend makes a guess, you provide a hint
 * that indicates how many digits in said guess match your secret number exactly in both digit and
 * position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * <p>
 * Write a function to return a hint according to the secret number and friend's guess,
 * use A to indicate the bulls and B to indicate the cows.
 * <p>
 * Please note that both secret number and friend's guess may contain duplicate digits.
 * <p>
 * Example 1:
 * <p>
 * Input: secret = "1807", guess = "7810"
 * <p>
 * Output: "1A3B"
 * <p>
 * Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 * <p>
 * 思路: 用一个count的array去相互制衡。关键是line 39和42， 这两行是先判断 < 或 > 再去做++或--的。
 */

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) { //必须要这样in-line的，因为不管if是true还是false都得执行。 这两个相互制衡
                    cows++;
                }
                if (count[guess.charAt(i) - '0']-- > 0) {
                    cows++;
                }
            }
        }
        return bulls + "A" + cows + "B";
    }
}
