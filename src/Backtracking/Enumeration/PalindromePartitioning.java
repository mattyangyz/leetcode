package Backtracking.Enumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 * <p>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 * <p>
 * 思路： 这就是枚举的思路，用backtracking去实现
 * <p>
 * 0    1    2
 * |    |
 * |    ————
 * |        |
 * -   1   2
 * |   |
 * |   ——
 * |    |
 * ——  2
 */

// 这题是backtracking去遍历每一种可能，注意一定是要把string给partition了，不是找单独的palindromie substring
public class PalindromePartitioning {

    List<List<String>> list = new ArrayList<>();

    public List<List<String>> partition(String s) {
        recur(s, new ArrayList<>(), 0);
        return list;
    }

    private void recur(String s, List<String> candidate, int index){
        if(index == s.length()){ // base case
            list.add(new ArrayList<>(candidate));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s.substring(index, i + 1))){
                candidate.add(s.substring(index, i + 1));
                recur(s, candidate, i + 1);
                candidate.remove(candidate.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
