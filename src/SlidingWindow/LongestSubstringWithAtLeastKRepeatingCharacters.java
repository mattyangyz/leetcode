//package SlidingWindow;
//难
//public class LongestSubstringWithAtLeastKRepeatingCharacters {
//
//    public int longestSubstring(String s, int k) {
//
//
//        int res = 0;
//        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {   // 允许字母出现的个数
//            res = Math.max(res, helper(s, k, numUniqueTarget));
//        }
//    }
//
//    private int helper(String s, int k, int numUniqueTarget){
//        int[] count = new int[128];
//        int start = 0;
//        int end = 0;
//        int numOfCharNoLessThanK = 0;
//        int numUnique = 0;
//
//        while (end < s.length()) {
//            if(count[s.charAt(end)]++ == 0){        // 看之前有没有出现过
//                numUnique++;
//            }
//            if (count[s.charAt(end++)] == k) {
//                numOfCharNoLessThanK++;
//            }
//
//            while(numUnique > )
//        }
//    }
//}
