package Array;

public class ShorestWordDistance {

    public static int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;
        for (int i = 0; i < word2.length(); i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < word2.length(); j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }
        return res;
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
