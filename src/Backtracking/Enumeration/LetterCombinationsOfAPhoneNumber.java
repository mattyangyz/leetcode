package Backtracking.Enumeration;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        combination("", digits, 0, ans);
        return ans;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ans) {

        if(offset >= digits.length()){
            ans.add(prefix);
            System.out.println(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset)) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ans);
        }
    }
}
