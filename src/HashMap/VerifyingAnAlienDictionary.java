package HashMap;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], map) > 0) {
                return false;
            }
        }
        return true;
    }

    private int compare(String s, String t, int[] map) {
        int m = s.length();
        int n = t.length();
        for (int i = 0; i < m && i < n; i++) {
            int cmp = map[s.charAt(i) - 'a'] - map[t.charAt(i) - 'a'];
            if (cmp != 0) {
                return cmp;
            }
        }
        return m - n;
    }
}
