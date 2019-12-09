//package StringRelated;
//
//public class LongestSubstringWithAtLeastKRepeatingCharacters {
//
//    public int longestSubstring(String s, int k) {
//        int ans = 0;
//
//        for (int i = 1; i <= 26; i++) {
//            ans = Math.max(ans, longestSubstring(s, k, i));
//        }
//        return ans;
//    }
//
//    private int longestSubstring(String s, int k, int numUniqueTarget) {
//        int[] map = new int[128];
//        int numUnique = 0;
//        int numNoLessThanK = 0;
//        int begin = 0;
//        int end = 0;
//        int ans = 0;
//
//        while (end < s.length()) {
//            if (map[s.charAt(end)]++ == 0) {
//                numUnique++;
//            }
//            if (map[s.charAt(end++)] == k) {
//                numUnique++;
//            }
//
//            while (numUnique > numUniqueTarget) {
//                if()
//            }
//        }
//    }
//}
