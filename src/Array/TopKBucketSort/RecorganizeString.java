package Array.TopKBucketSort;

/**
 * Given a string S, check if the letters can be rearranged so
 * that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 * <p>
 * <p>
 * 1 count letter appearance and store in hash[i]
 * 2 find the letter with largest occurence.
 * 3 put the letter into even index numbe (0, 2, 4 ...) char array
 * 4 put the rest into the array
 */
public class RecorganizeString {

    public String reorganizeString(String s) {
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int max = 0;
        int maxLetter = 0;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                maxLetter = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int index = 0;
        while (hash[maxLetter] > 0) {
            res[index] = (char) (maxLetter + 'a');
            index += 2;
            hash[maxLetter]--;
        }

        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {

                // 判断看之前的index有没有到最后一个了，如果到了就重新开始。
                // 放在里面是怕maxLetter很少，够不到最后一个letter就没有了，这样其他letter也可以补上。
                // 并且其他letter到了最后一个的话，就重新开始。
                if (index >= res.length) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                hash[i]--;
            }
        }

        return String.valueOf(res);
    }
}
