package Array;


/** Linkedin Review 1
 *
 * Can be done in one pass, with only one index variable.
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 *
 *
 * 思路: onepass 就可以做到， 两个index分别是word1和word2的index。注意计算距离的时候要用abs去计算。
 *
 */


public class ShorestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;

    }

    public static int shortestDistanceOnePass(String[] words, String word1, String word2) {
        int indexOne = -1;
        int indexTwo = -1;
        int minDistance = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexOne = i;
            }
            if (words[i].equals(word2)) {
                indexTwo = i;
            }

            if (indexOne != -1 && indexTwo != -1) {
                minDistance = Math.min(minDistance, Math.abs(indexOne - indexTwo));
            }
        }
        return minDistance;
    }
}
