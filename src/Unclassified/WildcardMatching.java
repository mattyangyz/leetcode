package Unclassified;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int stringPos = 0;
        int patternPos = 0;
        int match = 0;
        int star = -1;

        while (stringPos < s.length()) {
            if (patternPos < p.length() && (s.charAt(stringPos) == p.charAt(patternPos) || p.charAt(patternPos) == '?')) {
                stringPos++;
                patternPos++;
            } else if (patternPos < p.length() && p.charAt(patternPos) == '*') {
                star = patternPos;
                match = stringPos;
                patternPos++;
            } else if (star != -1) {
                patternPos = star + 1;
                match++;
                stringPos = match;
            } else {
                return false;
            }
        }
        while (patternPos < p.length() && p.charAt(patternPos) == '*') {
            patternPos++;
        }
        return patternPos == p.length();
    }
}
