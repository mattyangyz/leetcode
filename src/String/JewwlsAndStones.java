package String;


/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 */

public class JewwlsAndStones {

    public int numJewlsInStones(String j, String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j.indexOf(s.charAt(i)) > -1) {
                count++;
            }
        }
        return count;
    }
}
